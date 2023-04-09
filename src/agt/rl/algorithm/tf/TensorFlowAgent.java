package rl.algorithm.tf;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jason.asSemantics.Agent;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import rl.algorithm.AlgorithmRL;
import rl.algorithm.tf.rest.ActionRest;
import rl.algorithm.tf.rest.EnvironmentRest;
import rl.algorithm.tf.rest.StateRest;
import rl.beliefbase.BeliefBaseRL;
import rl.component.Action;
import rl.component.Observation;
import rl.component.ObservationParameter;
import rl.component.PlanLibraryRL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class TensorFlowAgent implements AlgorithmRL{
	
	public static String TARGET = "http://localhost:5002/agent/";
	public static String COLLECT_POLICY = "/next_train_action";
	public static String GREEDY_POLICY = "/next_best_action";
	public static String POLICY_FUNCTOR = "policy";
	public static String GREEDY_POLICY_FUNCTOR = "greedy";
	
	public static int N_ACTION_REAL = 10;
	
	protected abstract String getMethod();
	private String goal;
	
	private List<Observation> observations;
	private Map<String, Observation> observationsNameMap = new HashMap<>();
	private List<Action> actions;
	
	private Client client = ClientBuilder.newClient();
	
	private double preActionReward = 0;
	
	public TensorFlowAgent(String goal) {
		super();
		this.goal = goal;
	}

	@Override
	public Action nextAction(Map<Term, Term> parameters, Set<Action> action, Set<Literal> currentObservation,
			double reward, boolean isTerminal) {
		
		String policy = COLLECT_POLICY;
		for(Entry<Term, Term> parameter : parameters.entrySet()) {
			if(parameter.getKey().toString().equals(POLICY_FUNCTOR)) {
				if(parameter.getValue().toString().equals(GREEDY_POLICY_FUNCTOR)) {
					policy = GREEDY_POLICY;
				}
			}
		}
		
		List<Double> currentState = observationsToTF(currentObservation);
		
        StateRest<Double> state = new StateRest<>();
        state.setState(currentState);
        state.setState_type("double");
        state.setReward(preActionReward);
        state.setIs_terminal(isTerminal);
        
        preActionReward = reward;

        Response response = client.target(TARGET + goal + policy)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(state, MediaType.APPLICATION_JSON));

        @SuppressWarnings("unchecked")
		ActionRest<List<Integer>> actionRest = response.readEntity(ActionRest.class);
		return actions.get(actionRest.getAction().get(0).get(0));
	}

	@Override
	public double expectedReturn(Set<Action> action, Set<Literal> observation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initialize(Agent agent, BeliefBaseRL bb) {
		
		EnvironmentRest<Integer, Double> environment = new EnvironmentRest<>();
		environment.setAgent_type(getMethod());
		//actions specification
		actions = Action.discretizeActio
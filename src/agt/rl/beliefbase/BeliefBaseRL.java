
package rl.beliefbase;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import jason.asSemantics.Agent;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.bb.DefaultBeliefBase;
import rl.algorithm.AlgorithmRL;
import rl.algorithm.Sarsa;
import rl.algorithm.tf.Dqn;
import rl.algorithm.tf.Reinforce;

public class BeliefBaseRL extends DefaultBeliefBase {

	public static final String PARAMETER_FUNCTOR = "rl_parameter";
	public static final String OBSERVE_FUNCTOR = "rl_observe";
	public static final String ALGORITHM_FUNCTOR = "rl_algorithm";
	
	public static final String DQN_ID = "dqn";
	public static final String SARSA_ID = "sarsa";
	public static final String REINFORCE_ID = "reinforce";

	Agent agentReference;

	Map<Term, Term> parameter = new ConcurrentHashMap<>();// Parameter name -> parameter value
	Map<String, Set<String>> goalObservation = new ConcurrentHashMap<>();// goal, observation list
	Map<String, Set<Term>> goalObservationTerm = new ConcurrentHashMap<>();// goal, observation list
	Set<String> trackAll = new HashSet<>();
	
	Map<String, AlgorithmRL> rl = new ConcurrentHashMap<>();
	Set<String> rlActive = new HashSet<>();

	@Override
	public void init(Agent ag, String[] args) {
		agentReference = ag;
		super.init(ag, args);
	}

	@Override
	public boolean add(Literal bel) {
		addObservation(bel);
		return super.add(bel);
	}

	@Override
	public boolean add(int index, Literal bel) {
		addObservation(bel);
		return super.add(index, bel);
	}

	private void addObservation(Literal belief) {
		String functor = belief.getFunctor();
		if (functor.equals(PARAMETER_FUNCTOR)) {
			if (belief.getArity() == 2) {
				Term parameterName = belief.getTerm(0);
				Term parameterValue = belief.getTerm(1);
				parameter.put(parameterName, parameterValue);
				System.out.println("Set parameter " + parameterName + " to " + parameterValue);
			}
		} else if (functor.equals(OBSERVE_FUNCTOR)) {
			if (belief.getArity() == 2) {
				String goal = belief.getTerm(0).toString();
				Term observe = belief.getTerm(1);

				if (observe.isUnnamedVar()) {
					trackAll.add(goal);
					System.out.println("Goal " + goal + " tracks all");
				} else if (observe.isList()) {
					((ListTerm) observe).forEach(o -> {
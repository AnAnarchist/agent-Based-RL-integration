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
	
	protected abstract 
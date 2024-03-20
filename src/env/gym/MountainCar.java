package gym;

import java.util.HashMap;
import java.util.Map;

import cartago.Artifact;
import cartago.OPERATION;
import cartago.ObsProperty;
import gym.rest.GymRest;
import gym.rest.StateRest;
import simulation.EpisodicLogger;

import jason.asSyntax.Atom;

public class MountainCar extends Artifact{
	
	private static final boolean SHOW_VIEW = false;
	private static final int EVALUATION_INTERVAL = 100;
	private static final int EVALUATION_EPISODES = 100;
	
	GymRest<Double> mountainCar = new GymRest<>();
	
	private EpisodicLogger logger = new EpisodicLogger("MountainCar-v0", true, 15);
	private int trainEpisodeCount = 0;
	private int episodeReward = 0;
	private int episodeEvaluation = 0;
	private double evaluationRewards = 0;
	
	private int step = 0;
	
	@OPERATION
	public void init() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("show_gui", Boolean.toString(SHOW_VIEW));
		StateRest<Double> state = mountainCar.initialize("MountainCar-v0", parameters);
		defineObsProperty("position", state.getState().get(0));
		defineObsProperty("speed", state.getState().get(1));
		defineObsProperty("proximity", 0);
		
		defineObsProperty("rl_parameter", new Atom("policy"), new Atom("egreedy")
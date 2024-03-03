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
	private int ep
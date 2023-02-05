package rl.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import jason.asSemantics.Agent;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import rl.beliefbase.BeliefBaseRL;
import rl.component.Action;

public class Sarsa implements AlgorithmRL {

	BehaviourSerializer s
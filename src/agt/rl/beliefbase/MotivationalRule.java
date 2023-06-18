package rl.beliefbase;

import java.util.Iterator;

import jason.NoValueException;
import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.PredicateIndicator;
import jason.asSyntax.Rule;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;
import jason.bb.BeliefBase;

public class MotivationalRule {

	public static final PredicateIndicator REWARD_INDICATOR = new PredicateIndicator("rl_reward", 2);

	public static double getCurrentReward(String goal, Agent agentReference, BeliefBase bb) {
		double totalReward = 0;
		Iterator<Literal> reward = bb.getCandidateBeliefs(REWARD_INDICATOR);

		while (reward.hasNext()) {
			Literal rw = reward.next();
			if (!rw.isRule()) {
				if (rw.getArity() == 2) {
					Term litG
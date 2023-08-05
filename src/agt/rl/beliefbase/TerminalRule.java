package rl.beliefbase;

import java.util.Iterator;

import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import jason.asSyntax.PredicateIndicator;
import jason.asSyntax.Rule;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;
import jason.bb.BeliefBase;

public class TerminalRule {
	
	public static final PredicateIndicator TERMINAL_INDICATOR = new PredicateIndicator("rl_terminal", 1);
	
	public static boolean isCurrentStateTerminal(String goal, Agent agentReference, BeliefBase bb) {
		Iterator<Literal> terminalCandidate = bb.getCandidateBeliefs(TERMINAL_INDICATOR);
		if (terminalCandidate != null)
			while (terminalCandidate.hasNext()) {
				Literal terminal = terminalCandidate.next();
				if (!terminal.isRule()) {
					for (Term terminalGoal : terminal.getTerms()) {
						if (ter
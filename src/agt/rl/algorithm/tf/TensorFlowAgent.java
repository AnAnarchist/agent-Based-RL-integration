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
import java.util.H
package rl.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jason.NoValueException;
import jason.asSyntax.Literal;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.Term;

public class Observation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_SET_FUNCTOR = "set";
	public static final String PARAM_REAL_FUNCTOR = "real";
	public static final String PARAM_INT_FUNCTOR = "int";

	public enum ParameterType {
	    SET, REAL, INT
	}
	
	private final String name;
	private final List<ObservationParameter> parameters;
	
	public Observation(Term observationTerm){
		parameters = new ArrayList<>();
		
		Literal observation = (Literal) observationTerm;
		name = observation.getFunctor();
		for(Term param : observation.getTerms()) {
			Literal paramTypeLit = (Literal) param;
			String paramType = paramTypeLit.getFunctor();
			if(paramType.equals(PARAM_SET_FUNCTOR)) {
				List<String
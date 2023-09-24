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
				List<String> paramSet = new ArrayList<>();
				for(Term paramElement : paramTypeLit.getTerms()) {
					paramSet.add(paramElement.toString());
				}
				parameters.add(new ObservationParameter(paramSet));
			} else if(paramType.equals(PARAM_INT_FUNCTOR)) {
				try {
					int min = (int) ((NumberTerm)paramTypeLit.getTerm(0)).solve();
					int max = (int) ((NumberTerm)paramTypeLit.getTerm(1)).solve();
					parameters.add(new ObservationParameter(min, max));
				} catch (NoValueException e) {
					e.printStackTrace();
				}
			} else if(paramType.equals(PARAM_REAL_FUNCTOR)) {
				try {
					double min = ((NumberTerm)paramTypeLit.getTerm(0)).solve();
					double max = ((NumberTerm)paramTypeLit.getTerm(1)).solve();
					parameters.add(new ObservationParameter(min, max));
				} catch (NoValueException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Observation(String name, List<ObservationParameter> parameters){
		this.name = nam
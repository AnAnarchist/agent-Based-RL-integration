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
	
	public static final String PARAM_SET_FUNCTOR = "s
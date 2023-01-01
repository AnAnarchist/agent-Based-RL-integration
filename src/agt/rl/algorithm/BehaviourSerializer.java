package rl.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BehaviourSerializer {
	
	private String value_function_directory = "valuefunction";
	private String value_function_filename = "/learnedvf";
	private String value_function_extension = ".sar";
	private String value_function_file = value_function_directory + value_function_filename + value_function_extension;
	
	private
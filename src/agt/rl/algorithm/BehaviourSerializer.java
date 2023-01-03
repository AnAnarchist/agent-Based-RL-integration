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
	
	private ObjectOutputStream outObject;
	private FileOutputStream outFile;
	private int episodeForSaving = 1;
	private int writeEveryNEpisode = 400;
	
	private boolean saveProgress = false;
	private boolean loadProgress = false;
	
	private Object behaviour = null;
	
	public BehaviourSerializer() {
		File directory = new File(value_function_directory);
	    if (saveProgress && !directory.exists()){
	        dir
package simulation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EpisodicLogger {

	private int episodes = 0;
	private int episodesValue = 0;
	private double averageValue = 0;

	private final boolean saveResult;
	private final int saveResultAt;
	PrintWriter simultationResultsWriter;
	
	SimpleDateFormat sdf = new SimpleDateFormat("_yyyy:MM:dd_HH-mm-ss");

	public EpisodicLogger(String filename, boolean saveResult, int saveResultAt) {
		this.saveRe
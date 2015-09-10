package io;
import java.io.*;
import java.util.Scanner;
/**
 * This class takes the input file and parses it
 * for ListOfMessages
 * 
 * Then calls OutputFormat to print
 * 
 * The member writing this also needs to do unit tests
 * for this and ListOfMessages
 * @author John Parsons
 *
 */
public class InputParser {
	
	private String input_file;
	private String output_file;
	
	public static void main (String[] args){
		
	}
	
	public InputParser() {
		String [] noFiles;
		this(noFiles);
	}
	public InputParser(String[] files) {
		input_file = files[0];
		output_file = files[1];
	}
}


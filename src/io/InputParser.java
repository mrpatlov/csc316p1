package io;
import java.io.*;
import java.util.Scanner;

import lists.ListOfMessages;
/**
 * This class reads message data from an input file and returns a list of messages
 * 
 * 
 * The member writing this also needs to do unit tests
 * for this and ListOfMessages
 * @author John Parsons
 *
 */
public class InputParser {
	
	private String input_file;
	
	/**
	 * Parameterless constructor, if this is executed a FileNotFoundException will be generated.
	 */
	public InputParser() {
		this("");
	}
	
	/**
	 * Primary constructor
	 * @param finput name of input file containing message data
	 */
	public InputParser(String finput) {
		input_file = finput;
	}
	
	/**
	 * reads message data from input file, generating a list of messages as it does so.
	 * once all lines in file are processed, the list is returned
	 * 
	 * @return a list of all messages contained in input file
	 * @throws IllegalArgumentException if file line formatting does not follow correct pattern
	 */
	public ListOfMessages parseInput() throws IllegalArgumentException {
		File input = null;
		Scanner fReader = null;
		try{
			input = new File(input_file);
			fReader = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.out.println("Input file specified does not exist!");
			System.exit(0);
		}
		ListOfMessages messages = new ListOfMessages();
		while(fReader.hasNextLine()){
			String currentLine = fReader.nextLine();
			Scanner lineReader = new Scanner(currentLine);
			int messageNum;
			int packetNum;
			String message;
			if (lineReader.hasNextInt()){
				messageNum = lineReader.nextInt();
			} else {
				lineReader.close();
				fReader.close();
				throw new IllegalArgumentException("Bad input file formatting");
			}
			if (lineReader.hasNextInt()){
				packetNum = lineReader.nextInt();
			} else {
				lineReader.close();
				fReader.close();
				throw new IllegalArgumentException("Bad input file formatting");
			}
			if (lineReader.hasNext()){
				message = lineReader.nextLine();
			} else {
				lineReader.close();
				fReader.close();
				throw new IllegalArgumentException("Bad input file formatting");
			}
			messages.insert(messageNum, packetNum, message);
			lineReader.close();
		}
		fReader.close();
		return messages;
	}
}


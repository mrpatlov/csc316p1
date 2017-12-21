package io;

import lists.ListOfMessages;

/**
 * Title class for the Receiver program called from command line using the following format:
 * java Receiver input_file output_file
 * 
 * This program will read a list of message packets from a text file, arrange them into the proper order
 * and write the messages to a file.
 * 
 *Took contributors names out for identity purposes
 */
public class Receiver {

	/**
	 * This method must filter command line input and pass the input to the InputParser
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Proper usage of Receiver: 'java Receiver input_file output_file'");
			System.exit(0);
		}
		InputParser inParse = new InputParser(args[0]);
		ListOfMessages messages = null;
		try {
			messages = inParse.parseInput();
		} catch (IllegalArgumentException e) {
			System.out.println("Bad input file formatting!");
			System.exit(0);
		}
		OutputFormatter outFormat = new OutputFormatter(args[1]);
		outFormat.writeData(messages);
		System.out.println("Message Processing Complete!");
	}

}

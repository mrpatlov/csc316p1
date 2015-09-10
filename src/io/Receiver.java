package io;

/**
 * Title class for the Receiver program called from command line using the following format:
 * java Receiver input_file output_file
 * 
 * This program will read a list of message packets from a text file, arrange them into the proper order
 * and write the messages to a new file.
 * 
 * @author Rob
 *
 */
public class Receiver {

	/**
	 * This method must filter command line input and pass the input to the InputParser
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		if(args.length != 2) {
			System.exit("Proper usage of Receiver: 'java Receiver input_file output_file'");
		}
		InputParser inParse = new InputParser(args);
	}

}

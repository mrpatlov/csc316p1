package io;

import java.io.*;

import lists.ListOfMessages;
import lists.Message;

/**
 * This class formats output properly by 
 * reversing the stacks and adding errors where needed
 * Then prints the stacks
 * 
 * The member doing this class needs to do unit tests for 
 * this class and Message
 * @author Michael Patlovich
 *
 */

public class OutputFormatter {
	
	//This stores the file for the printer, closes at end of writeData
	private PrintWriter inFile;
	//This stores the message number
	private int messageNum;
	//This stores the message text
	private String messageText;
	//This stores the packet for the current message
	private int packet;
	//This stores the packet for the previous message
	private int prevPacket;
	//This stores the current message that you are on
	private Message message;

	/**
	 * This takes a string and creates a writer to an output file and catches if the file does not exist.
	 * @param string, the file name for the output file
	 */
	public OutputFormatter(String string) {
		try {
			inFile = new PrintWriter(string);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method takes a list of messages and prints them out to an output file 
	 * printing errors where needed.
	 * @param messages, a list of all the messages
	 */
	public void writeData(ListOfMessages messages) {
		messageNum = messages.peek();
		message = messages.pop();
		while(message != null) {
			inFile.println("--- Message " + messageNum);
			packet = message.peek();
			prevPacket = 0;
			messageText = message.pop();
			while(messageText != null) {
				if(packet == prevPacket + 1 || packet == prevPacket) {
					if(packet != message.peek()) inFile.println(messageText);
				} else {
					inFile.println("WARNING: packet " + (packet - 1) + " of message " + messageNum + " is missing");
					if(packet != message.peek()) inFile.println(messageText);
				}
				prevPacket = packet;
				if(message.peek() != -1) {
					packet = message.peek();
					messageText = message.pop();
				} else {
					break;
				}
			}
			inFile.println("--- End Message " + messageNum);
			inFile.println();
			if(messages.peek() != -1) {
				messageNum = messages.peek();
				message = messages.pop();
			} else {
				break;
			}
		}
		inFile.close();
	}
	
}

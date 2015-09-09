package lists;

public class ListOfMessages {
	
	
	/**
	 * pushes a new Message on top of the stack
	 * @param messageNumber
	 * @param packet
	 * @param message
	 */
	public void push(int messageNumber, int packet, String message){
		
	}
	
	/**
	 * inserts message in decending order
	 * @param messageNumber
	 * @param packet
	 * @param message
	 */
	public void insert(int messageNumber, int packet, String message){
		
	}
	
	/**
	 * returns the top Message
	 * @return
	 */
	public Message pop(){
		
	}
	
	private class Node{
		Node node;
		Message message;
		int MessageNumber;
	}
}

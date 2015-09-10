package lists;

public class Message {
	
	
	public Message(int packet, String message) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * pushes a new packet on top of the stack
	 * @param packet
	 * @param message
	 */
	public void push(int packet, String message){
		
	}
	
	/**
	 * inserts packet in decending order
	 * @param packet
	 * @param message
	 */
	public void insert(int packet, String message){
		
	}
	
	/**
	 * returns the top Message
	 * @return
	 */
	public Message pop(){
		
	}
	
	private class Node{
		Node node;
		String message;
		int packet;
	}
}

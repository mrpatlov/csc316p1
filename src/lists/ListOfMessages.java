package lists;

public class ListOfMessages {
	
	private Node head;
	
	public ListOfMessages(){
		head = null;
	}
	/**
	 * pushes a new Message on top of the stack
	 * @param messageNumber
	 * @param packet
	 * @param message
	 */
	public void push(int messageNumber, int packet, String message){
		head = new Node (messageNumber, packet, message, head);
		
	}
	
	/**
	 * inserts message in decending order
	 * @param messageNumber
	 * @param packet
	 * @param message
	 */
	public void insert(int messageNumber, int packet, String message){
		if (head == null || head.MessageNumber > messageNumber){
			head = new Node (messageNumber, packet, message, head);
			return;
		}
		Node temp = head;
		while (temp != null){
			if (temp.MessageNumber == messageNumber){
				temp.message.insert(packet, message);
				return;
			}
			if (temp.next == null){
				temp.next = new Node (messageNumber, packet, message, null);
				return;
			}
			if (temp.next.MessageNumber > messageNumber){
				temp.next = new Node (messageNumber, packet, message, temp.next);
				return;
			}
			else{
				temp = temp.next;
			}
		}
		//should never get here but throwing an exception just in case
		throw new IndexOutOfBoundsException();
		
	}
	
	/**
	 * returns the top Message and removes it from stack
	 * @return the top Message from stack
	 */
	public Message pop(){
		if(head == null) return null;
		Node temp = head;
		head = head.next;
		return temp.message;
		
	}
	
	/**
	 * returns messageNumber with out removing item from stack
	 * returns -1 if list is empty
	 * @return the message number of first message in list
	 */
	public int peek(){
		if(head == null) return -1;
		return head.MessageNumber;
	}
	
	private class Node{
		public Node next;
		public Message message;
		public int MessageNumber;
		
		public Node (int messageNumber, int packet, String Message, Node next){
			this.next = next;
			message = new Message(packet, Message);
			this.MessageNumber = messageNumber;
			
		}
	}
}

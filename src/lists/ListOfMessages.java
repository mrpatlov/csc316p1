package lists;
/**
 * This class is a list of lists.  Each item in this class
 * is a stack of packets that makes up a message
 * @author Jeremy Vanderwall
 *
 */
public class ListOfMessages {
	
	private Node head;
	
	/**
	 * Constructor for null list
	 */
	public ListOfMessages(){
		head = null;
	}
	/**
	 * pushes a new Message on top of the stack
	 * @param messageNumber The message Number
	 * @param packet the packet number
	 * @param message the message fragment
	 */
	public void push(int messageNumber, int packet, String message){
		head = new Node (messageNumber, packet, message, head);
		
	}
	
	/**
	 * inserts message in ascending order
	 * @param messageNumber the message number
	 * @param packet the packet number
	 * @param message the message fragment
	 */
	public void insert(int messageNumber, int packet, String message){
		if (head == null || head.messageNumber > messageNumber){
			head = new Node (messageNumber, packet, message, head);
			return;
		}
		Node temp = head;
		while (temp != null){
			if (temp.messageNumber == messageNumber){
				temp.message.insert(packet, message);
				return;
			}
			if (temp.next == null){
				temp.next = new Node (messageNumber, packet, message, null);
				return;
			}
			if (temp.next.messageNumber > messageNumber){
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
		if(head == null){
			return -1;
		}
		return head.messageNumber;
	}
	
	/**
	 * node class for internal linked list
	 * @author Jeremy Vanderwall
	 *
	 */
	private class Node {
		public Node next;
		public Message message;
		public int messageNumber;
		
		/**
		 * Constructor for a Node
		 * @param messageNumber The Message number for the packet
		 * @param packet the packet number for the packet
		 * @param Message the string associated with the packet
		 * @param next Next node in Linked list
		 */
		public Node (int messageNumber, int packet, String message, Node next){
			this.next = next;
			this.message = new Message(packet, message);
			this.messageNumber = messageNumber;
			
		}
	}
}

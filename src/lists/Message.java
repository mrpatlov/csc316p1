package lists;

public class Message {
	
	Node head;
	
	public Message(int packet, String message) {
		head = new Node(packet, message, null);
	}

	/**
	 * pushes a new packet on top of the stack
	 * @param packet
	 * @param message
	 */
	public void push(int packet, String message){
		
		head = new Node(packet, message, head );
		
	}
	
	/**
	 * inserts packet in descending order
	 * @param packet
	 * @param message
	 */
	public void insert(int packet, String message){
		if (head == null || head.packet > packet){
			head = new Node( packet, message, head);
		}
		Node temp = head;
		while (temp != null){
			if (temp.next == null){
				temp.next = new Node (packet, message, null);
				return;
			}
			if (temp.next.packet > packet){
				temp.next = new Node ( packet, message, temp.next);
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
	 * returns the top Message
	 * @return
	 */
	public String pop(){
		String temp = head.message;
		head = head.next;
		return temp;
		
	}
	
	public int peek(){
		return head.packet;
	}
	
	private class Node{
		Node next;
		int packet;
		String message;
		
		public Node (int packet, String message, Node next){
			this.next = next;
			this.packet = packet;
			this.message = message;
		}
		
	}
}

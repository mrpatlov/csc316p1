package lists;

import java.util.EmptyStackException;

public class Message {
	
	int packet;
	String message;
	Node head;
	
	public Message(int packet, String message) {
		this.packet = packet;
		this.message = message;
		this.head = null;
	}

	/**
	 * pushes a new packet on top of the stack
	 * @param packet
	 * @param message
	 */
	public void push(int packet, String message){
		
		head = new Node(head, message, packet);
		
	}
	
	/**
	 * inserts packet in descending order
	 * @param packet
	 * @param message
	 */
	public void insert(int packet, String message){
		Node current = head;
		if(packet >= head.data.packet || head.equals(null)){
			head = new Node(head, message, packet);
		} else {
			while(packet < current.next.data.packet){
				current = current.next;
			}
			current.next = new Node(current.next, message, packet);
		}
	}
	
	/**
	 * returns the top Message
	 * @return
	 */
	public Message pop(){
		if(this.head == null){
			throw new EmptyStackException();
		}
		Message temp = head.data;
		head = head.next;
		return temp;
	}
	
	private class Node{
		Node next;
		Message data;
		
		public Node(Node next, String message, int packet){
			
			this.next = next;
			this.data = new Message(packet, message);
			
		}
	}
}

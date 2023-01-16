/**
 * 
 * @author BalthazarSai
 * @date 16 Jan 2023
 */
public class LinkedList {
	Node head, tail = null;
	
	static class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int value) {
			data = value;
		}
	}
	
	/** Adds a Node to the linked list based on user input
	 * 
	 * @param value The integer value that the Node will contain
	 */
	public void addNode(int value) {
		
		Node newNode = new Node(value);
		
		if(head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		}else {
            tail.next = newNode;  
            newNode.prev = tail;  
            tail = newNode;    
            tail.next = null;  
		}
	}
	
	/** Removes a Node from the linked list based on user input
	 *  **BROKEN**
	 * 
	 * @param value The integer value of the Node to be removed
	 */
	public void removeNode(int value) {
		Node target = searchNode(value);
		if(target != null) {
			if(target.prev != null) target.prev.next = target.next;
			else head.next = target.next;
			if(target.next == null) target.next.prev = target.prev;
		}else {
			System.out.println("Target not Found!");
		}
	}
	
	/** Searches for a Node based on its contained value
	 * 
	 * @param value The integer value of the Node to be found
	 * @return The Node if its found or Null if its not
	 */
	public Node searchNode(int value) {
		Node index = head;
		if(head == null) {
			System.out.println("Linked List is empty");
			return head;
		}else {
			while(index != null && index.data != value) {
				index = index.next;
			}
			return index;
		}
	}
	
	/** Prints the Linked List
	 * 
	 */
	public void printLinkedList() {
		Node index = head;
		if(head == null) {
			System.out.println("Linked List is empty");
		}else {
			while(index != null) {
				if(index.prev == null) System.out.print("[{"+index.prev+"}");
				else System.out.print("[{"+index.prev.data+"}");
				System.out.print("<|"+index.data+"|>");
				if(index.next == null) System.out.print("{"+index.next+"} ] -- ");
				else System.out.print("{"+index.next.data+"}] -- ");
				
				index = index.next;
			}
			System.out.println("");
		}
	}
}

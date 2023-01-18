/**
 * 
 * @author balthazarSai
 * @date 18 Jan 2023
 *
 */
public class Queue {
	int head;
	int tail;
	int QueueSize;
	int[] queue;
	
	/** The Queue Class constructor
	 * 
	 * @param queueSize The size of the queue to be created
	 */
	public Queue(int queueSize){
		QueueSize = queueSize;
		queue = new int[QueueSize];
		head = 0;
		tail = 0;
	}
	
	/** Adds an element to the queue
	 * 
	 * @param element An integer value to be added to the queue
	 */
	public void enqueue(int element) {
		queue[tail] = element;
		if(tail == QueueSize-1)tail = 0;
		else tail++;
	}
	
	/** Removes the element at the {@link #head} index position of the Queue
	 * 
	 * @return Returns the removed element
	 */
	public int dequeue() {
		int tmp = queue[head];
		if(head == QueueSize-1)head = 0;
		else head++;
		return tmp;
	}
	
	/** Prints the Queue and the pointer positions
	 *  
	 */
	public void printQueue() {
		for(int i=0;i<QueueSize;i++) {
			System.out.print(" ["+i+"]: "+queue[i]);
			if(i== head)System.out.print(" < HEAD");
			if(i == tail)System.out.print(" < TAIL");
			System.out.println("");
		}
	}
}

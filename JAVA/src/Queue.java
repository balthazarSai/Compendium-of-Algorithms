
public class Queue {
	int head;
	int tail;
	int QueueSize;
	int[] queue;
	
	public Queue(int queueSize){
		QueueSize = queueSize;
		queue = new int[QueueSize];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(int element) {
		queue[tail] = element;
		if(tail == QueueSize-1)tail = 0;
		else tail++;
	}
	
	public int dequeue() {
		int tmp = queue[head];
		if(head == QueueSize-1)head = 0;
		else head++;
		return tmp;
	}
	
	public void printQueue() {
		for(int i=0;i<QueueSize;i++) {
			System.out.print(" ["+i+"]: "+queue[i]);
			if(i== head)System.out.print(" < HEAD");
			if(i == tail)System.out.print(" < TAIL");
			System.out.println("");
		}
	}
}


public class Queue {
	int head = 0;
	int tail = 0;
	int QueueSize;
	int[] queue;
	
	public Queue(int queueSize){
		QueueSize = queueSize;
		queue = new int[QueueSize];
	}
	
	public void enqueue(int element) {
		queue[tail] = element;
		if(tail == QueueSize)tail = 1;
		else tail++;
	}
	
	public int dequeue() {
		int tmp = queue[head];
		if(head == QueueSize)head = 1;
		else head++;
		return tmp;
	}
	
	public void printQueue() {
		for(int i=0;i<QueueSize;i++) {
			if(i >= head && i< tail) {
				System.out.print(" ["+i+"]: "+queue[i]);
			}else {
				System.out.print(" ["+i+"]: #");
			}
			if(i== head)System.out.println(" < HEAD");
			else if(i == tail)System.out.println(" < TAIL");
			else System.out.println("");
		}
	}
}

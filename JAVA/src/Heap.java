
public class Heap {
	
	int[] heap;
	int heapSize = 0;
	
	public Heap(int[] A){
		this.heapSize = A.length;
		this.heap = A;
	}
	
	public int left(int index) {
		return index*2+1;
	}
	
	public int right(int index) {
		return (index*2)+2;
	}
	
	public int parent(int index) {
		return (int) Math.floor((double)(index/2));
	}
	
	public void maxHeapify(Heap A,int index) {
		int largest;
		int l = left(index);
		int r = right(index);
		if (l <= A.heapSize-1 && A.heap[l] > A.heap[index]) largest = l;
		else largest = index;
		if (r <= A.heapSize-1 && A.heap[r] > A.heap[largest]) largest = r;
		if (largest != index) {
			int tmp = A.heap[index];
			A.heap[index] = A.heap[largest];
			A.heap[largest] = tmp;
			maxHeapify(A,largest);
		}
	}
	
	public void buildMinHeap(Heap A) {
		for(int i = Math.floorDiv(A.heap.length, 2);i>=0;i--){
			minHeapify(A,i);
		}
	}
	
	public void minHeapify(Heap A,int index) {
		int smallest;
		int l = left(index);
		int r = right(index);
		if (l <= A.heapSize-1 && A.heap[l] < A.heap[index]) smallest = l;
		else smallest = index;
		if (r <= A.heapSize-1 && A.heap[r] < A.heap[smallest]) smallest = r;
		if (smallest != index) {
			int tmp = A.heap[index];
			A.heap[index] = A.heap[smallest];
			A.heap[smallest] = tmp;
			minHeapify(A,smallest);
		}
	}
	
	public void buildMaxHeap(Heap A) {
		for(int i = Math.floorDiv(A.heap.length, 2);i>=0;i--){
			maxHeapify(A,i);
		}
	}
	
	public void heapSort(Heap A) {
		buildMaxHeap(A);
		for(int i = A.heap.length-1;i>=1;i--) {
			int tmp = A.heap[0];
			A.heap[0] = A.heap[i];
			A.heap[i] = tmp;
			A.heapSize--;
			maxHeapify(A,0);
		}
	}
	
	public int heapExtractMax(Heap A) {
		if(A.heapSize < 1) System.out.println("Heap Underflow");
		int max = A.heap[0];
		A.heap[0] = A.heap[A.heapSize];
		A.heapSize--;
		maxHeapify(A,0);
		return max;
	}
	
	public int heapExtractMin(Heap A) {
		if(A.heapSize < 1) System.out.println("Heap Underflow");
		int min = A.heap[0];
		A.heap[0] = A.heap[A.heapSize];
		A.heapSize--;
		minHeapify(A,0);
		return min;
	}
}

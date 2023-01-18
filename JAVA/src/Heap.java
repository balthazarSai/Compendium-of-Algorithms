/**
 * 
 * @author balthazarSai
 * @date 16 Jan 2023
 */
public class Heap {
	
	int[] heap;
	int heapSize = 0;
	
	/** The heap class constructor
	 * 
	 * @param A An integer array to be passed on as a heap
	 */
	public Heap(int[] A){
		this.heapSize = A.length;
		this.heap = A;
	}
	
	/** Finds the left child of a given element using the Heap properties
	 * 
	 * @param index The index of the element for which we want to find the LEFT child
	 * @return The index of the LEFT child
	 */
	public int left(int index) {
		return index*2+1;
	}
	
	/** Finds the right child of a given element using the Heap properties
	 * 
	 * @param index The index of the element for which we want to find the RIGHT child
	 * @return The index of the RIGHT child
	 */
	public int right(int index) {
		return (index*2)+2;
	}
	
	/** Finds the parent of a given element using the Heap properties.
	 * 
	 * @param index The index of the element for which we want to find the PARENT
	 * @return The index of the PARENT
	 */
	public int parent(int index) {
		return (int) Math.floor((double)(index/2));
	}
	
	/** Converts a Heap into a max Heap called privately from {@link #buildMaxHeap(Heap)}
	 * 
	 * @param A The Heap that we want to convert to a max Heap
	 * @param index The starting index decided by the calling function
	 */
	private void maxHeapify(Heap A,int index) {
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
	
	/** Builds a MAX Heap from a given Heap
	 * 
	 * @param A The Heap to be converted
	 */
	public void buildMaxHeap(Heap A) {
		for(int i = Math.floorDiv(A.heap.length, 2);i>=0;i--){
			maxHeapify(A,i);
		}
	}
	
	/** Converts a Heap into a min Heap called privately from {@link #buildMinHeap(Heap)}
	 * 
	 * @param A The Heap that we want to convert to a min Heap
	 * @param index The starting index decided by the calling function
	 */
	private void minHeapify(Heap A,int index) {
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
	
	/** Builds a MIN Heap from a given heap
	 * 
	 * @param A The Heap to be converted
	 */
	public void buildMinHeap(Heap A) {
		for(int i = Math.floorDiv(A.heap.length, 2);i>=0;i--){
			minHeapify(A,i);
		}
	}
	
	/** Sorts the given Heap
	 * 
	 * @param A The given Heap
	 */
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
	
	/** UNUSED Extracts the MAX element of a MAX Heap
	 * 
	 * @param A The heap for which to perform the extraction
	 * @return The max element
	 */
	private int heapExtractMax(Heap A) {
		if(A.heapSize < 1) System.out.println("Heap Underflow");
		int max = A.heap[0];
		A.heap[0] = A.heap[A.heapSize];
		A.heapSize--;
		maxHeapify(A,0);
		return max;
	}
	
	/** USUSED Extracts the MIN element of a MIN Heap
	 * 
	 * @param A The heap for which to perform the extraction
	 * @return The min element
	 */
	private int heapExtractMin(Heap A) {
		if(A.heapSize < 1) System.out.println("Heap Underflow");
		int min = A.heap[0];
		A.heap[0] = A.heap[A.heapSize];
		A.heapSize--;
		minHeapify(A,0);
		return min;
	}
}

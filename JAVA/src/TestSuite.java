import static org.junit.Assert.*;
import org.junit.Test;

public class TestSuite {
	
	@Test
	public void testStack() {
		Stack stck = new Stack(5);
		int[] expected = new int[]{1,2,3,4,5};
		for(int i=0;i<expected.length;i++) {
			stck.push(expected[i]);
			assertEquals(i,stck.stackPointer);
		}
		assertArrayEquals(expected, stck.stack);
		
		stck.push(1);
		assertArrayEquals(expected,stck.stack);
		assertEquals(true,stck.checkOverflow());
		
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		assertEquals(-1,stck.stackPointer);
		
		stck.pop();
		assertEquals(true,stck.checkUnderflow());
	}
	
	@Test
	public void testQueue() {
		Queue que = new Queue(5);
		int[] expected = {5,6,7,8,9};
		for(int i=0;i<(expected.length-1);i++) {
			que.enqueue(i);
			assertEquals(i+1,que.tail);
		}
		que.enqueue(5);
		assertEquals(0,que.tail);
		for(int i=0;i<(expected.length-1);i++) {
			que.enqueue(i+5);
			assertEquals(i+1,que.tail);
		}
		que.enqueue(9);
		assertEquals(0,que.tail);
		
		assertArrayEquals(expected,que.queue);
		
		for(int i=0;i<(4);i++) {
			que.dequeue();
			assertEquals(0,que.tail);
			assertEquals(i+1,que.head);
		}
		que.dequeue();
		assertEquals(0,que.tail);
		assertEquals(0,que.head);
		assertArrayEquals(expected,que.queue);
		
	}
	
	@Test
	public void testHeap() {
		int[] expected = {100,1,2,50,55,67,10,12,140};
		Heap hp = new Heap(expected);
		hp.heapSort(hp);
		assertEquals(1,hp.heap[0]);
		assertEquals(2,hp.heap[1]);
		assertEquals(100,hp.heap[7]);
		assertEquals(140,hp.heap[8]);
		
	}
	
	@Test
	public void testBST() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(100);
		bst.addNode(1);
		bst.addNode(25);
		bst.addNode(5);
		bst.addNode(115);
		bst.addNode(12);
		assertEquals(1,bst.treeMin(bst.root).data);
		assertEquals(115,bst.treeMax(bst.root).data);
		assertEquals(12,bst.treeSuccessor(bst.treeSearch(bst.root, 5)).data);
		bst.treeDelete(bst, bst.treeSearch(bst.root, 25));
		assertEquals(null,bst.treeSearch(bst.root, 25));
	}
	
	@Test
	public void testLL() {
		LinkedList llst = new LinkedList();
		llst.addNode(5);
		llst.addNode(15);
		assertEquals(15,llst.searchNode(15).data);
		//Work In Progress
	}


	
}

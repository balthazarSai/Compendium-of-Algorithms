import java.util.Scanner;

/**
 * 
 * @author BalthazarSai
 * @date 15 Jan 2023
 */
public class Algorithms {
	
	static boolean appRunning = true;
	
	static int[] userTempArray;
	
	static int usageType;
	
	static int stackSize;
	static Stack userStack;
	
	static int queueSize;
	static Queue userQueue;
	
	static LinkedList userLinkedList;
	static BinarySearchTree userBST;
	
	static Heap userHeap;
	
	static Huffman userHuffman;
	
	static StringBuilder sb;
	
	static Scanner scan = new Scanner(System.in);

	
	public static void main(String[] args) {
		System.out.println("---Select an option---");
		while(appRunning) {
			displayMainMenu();
		}
	}
	
	/** Displays the main app menu in terminal
	 * 
	 */
	private static void displayMainMenu() { 
		System.out.println("--*Data Structures*--");
		System.out.println("Stack			-> 0");
		System.out.println("Queue			-> 1");
		System.out.println("Linked List		-> 2");
		System.out.println("BST			-> 3");
		System.out.println("Huffman Trees		-> 4");
		System.out.println("");
		System.out.println("--*Sorting Algorithms*--");
		System.out.println("Insertion Sort		-> 5");
		System.out.println("Merge Sort		-> 6");
		System.out.println("Heap Sort		-> 7");
		System.out.println("Quick Sort		-> 8");
		System.out.println("Array Menu		-> 9");
		System.out.println("..			-> 10");
		String userChoiceMM = scan.nextLine();
		
		try{
			usageType = Integer.parseInt(userChoiceMM);
			switch(usageType) {
			case 0:
				stackBuilder();
				stackHandler();
				break;
			case 1:
				queueBuilder();
				queueHandler();
				break;
			case 2:
				linkedListBuilder();
				linkedListHandler();
				break;
			case 3:
				BSTBuilder();
				BSTHandler();
				break;
			case 4:
				huffmanBuilder();
				huffmanHandler();
				break;
			case 5:
				if(userTempArray == null) displayArrayMenu();
				insertionSort(userTempArray);
				displayArrayMenu();
				break;
			case 6:
				if(userTempArray == null) displayArrayMenu();
				int[] temp = userTempArray;
				System.out.println("---Original Array---");
				printArray(temp);
 				mergeSort(userTempArray,userTempArray.length);
				System.out.println("---Merge Sorted Array---");
				printArray(userTempArray);
				userTempArray = temp;
				displayArrayMenu();
				break;
			case 7:
				if(userTempArray == null) displayArrayMenu();
				heapBuilder();
				heapHandler();
				break;
			case 8:
				if(userTempArray == null) displayArrayMenu();
				int[] temp2 = userTempArray;
				System.out.println("---Original Array---");
				printArray(temp2);
 				quickSort(userTempArray,0,userTempArray.length-1);
				System.out.println("---Quick Sorted Array---");
				printArray(userTempArray);
				userTempArray = temp2;
				displayArrayMenu();
				break;
			case 9:
				displayArrayMenu();
				break;
			case 10:
				System.out.println("Bye Bye!");
				appRunning = false;
				break;
			default:
				System.out.println("Invalid Input Please choose again!");
				displayMainMenu();
				break;
			}
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            
        }
		
	}
	
	/** Displays the array menu in terminal
	 * 
	 */
	private static void displayArrayMenu() {
		int arrayMenuChoice;
		
		System.out.println("-**Array Menu**-");
		System.out.println("New Array	-> 1");
		System.out.println("Display Array	-> 2");
		System.out.println("Main Menu	-> 3");
		
		String userChoiceArrayMenu = scan.nextLine();
		
		try{
			arrayMenuChoice = Integer.parseInt(userChoiceArrayMenu);
			switch(arrayMenuChoice) {
			case 1:
				arrayCreateHandler();
				break;
			case 2:
				arrayDisplayHandler();
				break;
			case 3:
				displayMainMenu();
				break;
			default:
				System.out.println("You can only choose a number 1-3");
				break;
			}
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
        }
		displayArrayMenu();
		
	}
	
	/** Creates an array based on user input from the terminal
	 * 
	 */
	private static void arrayCreateHandler() {
		int arrSize = 0;
		int tmpIn = 0;
		
		System.out.println("How many elements would you like?");
		String userSizeChoice = scan.nextLine();
		try{
			arrSize = Integer.parseInt(userSizeChoice);
			userTempArray = new int[arrSize];
			
			System.out.println("Enter your values");
			for(int i=0;i<arrSize;i++) {
				System.out.printf(" [%d]: ",i);
				String elementTemp = scan.nextLine();
				try{
					tmpIn = Integer.parseInt(elementTemp);
		        }
		        catch (NumberFormatException ex){
		            System.out.println("Invalid Input, Please Choose again");
		            i--;
		            continue;
		        }
				userTempArray[i] = tmpIn;	
			}
			System.out.println("Created...");
			displayArrayMenu();
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            arrayCreateHandler();
        }

	}
	
	/** Displays the user saved array
	 * 
	 */
	private static void arrayDisplayHandler() {
		if(userTempArray == null) {
			System.out.println("No array defined");
		}else {
			System.out.println("--Showing Array--");
			for(int i=0;i<userTempArray.length;i++) {
				System.out.print(" ["+i+"]: "+userTempArray[i]);
			}
			System.out.println("");
		}
		displayArrayMenu();
	}
	
	/** Builds a stack object based on user input from the terminal
	 * 
	 */
	private static void stackBuilder() {
		if (stackSize == 0) {
			System.out.println("Define Stack Size");
			String userStackSize = scan.nextLine();
			if(isNumber(userStackSize)) {
				stackSize = Integer.parseInt(userStackSize);
				userStack = new Stack(stackSize);
				stackHandler();
			}else {
				displayMainMenu();
			}
		} 
	}
	
	/** Handles all operations to be performed on the saved stack object through user input from the terminal
	 * 
	 */
	private static void stackHandler() {
		System.out.println("-**Stack Operations**-");
		System.out.println("Push Element	-> 1");
		System.out.println("Pop Element	-> 2");
		System.out.println("Display Stack	-> 3");
		System.out.println("Main Menu	-> 4");
		
		int stackOp = 0;
		String userStackOp = scan.nextLine();
		if(isNumber(userStackOp)) {
			stackOp = Integer.parseInt(userStackOp);
			switch(stackOp) {
			case 1:
				if(!userStack.checkOverflow()) {
					System.out.println("Enter a number: ");
					int element = 1;
					String userElement = scan.nextLine();
					if(isNumber(userElement) ) {
						element = Integer.parseInt(userElement);
						userStack.push(element);
					}		
				}
				break;
			case 2:
				if(!userStack.checkUnderflow()) {
					System.out.println("Removed "+userStack.pop());
				}
				break;
			case 3:
				userStack.printStack();
				break;
			case 4:
				displayMainMenu();
				break;
			default:
				System.out.println("Invalid Input, Please Choose again");
				break;
			}
		}
		stackHandler();
	}
	
	/** Builds a queue object based on user input from the terminal
	 * 
	 */
	private static void queueBuilder() {
		if (queueSize == 0) {
			System.out.println("Define Queue Size");
			String userQueueSize = scan.nextLine();
			if(isNumber(userQueueSize)) {
				queueSize = Integer.parseInt(userQueueSize);
				userQueue = new Queue(queueSize);
				queueHandler();
			}else {
				displayMainMenu();
			}
		} 
		
		
	}
	
	/** Handles all operations to be performed on the saved queue object through user input from the terminal
	 * 
	 */
	private static void queueHandler() {
		System.out.println("-**Queue Operations**-");
		System.out.println("Enqueue Element	-> 1");
		System.out.println("Dequeue Element	-> 2");
		System.out.println("Display Queue	-> 3");
		System.out.println("Main Menu	-> 4");
		
		int queueOp = 0;
		String userQueueOp = scan.nextLine();
		if(isNumber(userQueueOp)) {
			queueOp = Integer.parseInt(userQueueOp);
		}else {
			queueHandler();
		}
		switch(queueOp) {
		case 1:
			System.out.println("Enter a number: ");
			int element = 0;
			String userElement = scan.nextLine();
			if(isNumber(userElement)) {
				element = Integer.parseInt(userElement);
				userQueue.enqueue(element);
			}
			break;
		case 2:
			System.out.println("Removed "+userQueue.dequeue());
			break;
		case 3:
			userQueue.printQueue();
			break;
		case 4:
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid Input, Please Choose again");
		}
		queueHandler();
	}
	
	/** Builds a Linked List object based on user input from the terminal
	 * 
	 */
	private static void linkedListBuilder() {
		userLinkedList = new LinkedList();
	}
	
	/** Handles all operations to be performed on the saved Linked List object through user input from the terminal
	 * 
	 */
	private static void linkedListHandler() {
		System.out.println("-**Linked List Operations**-");
		System.out.println("Add Node	-> 1");
		System.out.println("Remove Node	-> 2");
		System.out.println("Search Node	-> 3");
		System.out.println("Display LL	-> 4");
		System.out.println("Main Menu	-> 5");
		
		int linkedListOp = 0;
		String userlinkedListOp = scan.nextLine();
		if(isNumber(userlinkedListOp)) {
			linkedListOp = Integer.parseInt(userlinkedListOp);
			switch(linkedListOp) {
			case 1:
				System.out.println("Enter a number: ");
				int element = 1;
				String userElement = scan.nextLine();
				if(isNumber(userElement)) {
					element = Integer.parseInt(userElement);
					userLinkedList.addNode(element);
				}
				break;
			case 2:
				System.out.println("Enter a number: ");
				element = 1;
				userElement = scan.nextLine();
				if(isNumber(userElement)) {
					element = Integer.parseInt(userElement);
					userLinkedList.removeNode(element);
				}
				break;
			case 3:
				System.out.println("Enter a number: ");
				element = 1;
				userElement = scan.nextLine();
				if(isNumber(userElement)) {
					element = Integer.parseInt(userElement);
					if(userLinkedList.searchNode(element) == null) System.out.println("Output: "+userLinkedList.searchNode(element));
					else System.out.println("Output: "+userLinkedList.searchNode(element).data);
				}
				break;
			case 4:
				userLinkedList.printLinkedList();
				break;
			case 5:
				displayMainMenu();
				break;
			default:
				System.out.println("Invalid Input, Please Choose again");
			}
		}
		linkedListHandler();
	}
	
	/** Builds a Binary Search Tree object
	 * 
	 */
	private static void BSTBuilder() {
		userBST = new BinarySearchTree();
	}
	
	/** Handles all operations to be performed on the saved Binary Search Tree object through user input from the terminal
	 * 
	 */
	private static void BSTHandler() {
		System.out.println("-**BST Operations**-");
		System.out.println("Add Node	-> 1");
		System.out.println("Delete Node	-> 2");
		System.out.println("Tree Min	-> 3");
		System.out.println("Tree Max	-> 4");
		System.out.println("Tree Successor	-> 5");
		System.out.println("Tree Inorder	-> 6");
		System.out.println("Tree Display	-> 7");
		System.out.println("Main Menu	-> 8");
		
		int BSTOp = 0;
		String userBSTOp = scan.nextLine();
		if(isNumber(userBSTOp)) {
			BSTOp = Integer.parseInt(userBSTOp);
			switch(BSTOp) {
			case 1:
				System.out.println("Enter the element you want to add: ");
				int addNode = 0;
				String useraddNode = scan.nextLine();
				if(isNumber(useraddNode)) {
					addNode = Integer.parseInt(useraddNode);
					userBST.addNode(addNode);
				}
				break;
			case 2:
				if(userBST.root == null) {
					System.out.println("Tree Empty!");
				}else {
					sb = new StringBuilder();
					System.out.println("Which Element do you want to delete?");
					userBST.traversePreOrder(sb, "", "", userBST.root);
					System.out.print(sb.toString());
					int delNode = 0;
					String userdelNode = scan.nextLine();
					if(isNumber(userdelNode)) {
						delNode = Integer.parseInt(userdelNode);
						if(userBST.treeSearch(userBST.root,delNode) == null) {
							System.out.println("Element not on the tree!");
						}else {
							userBST.treeDelete(userBST, userBST.treeSearch(userBST.root,delNode));
							System.out.println("Element Deleted!");
						}
					}
				}
				break;
			case 3:
				if(userBST.root == null)System.out.println("Tree is Empty!");
				else System.out.println("Tree min is: "+userBST.treeMin(userBST.root).data);
				break;
			case 4:
				if(userBST.root == null)System.out.println("Tree is Empty!");
				else System.out.println("Tree max is: "+userBST.treeMax(userBST.root).data);
				break;
			case 5:
				if(userBST.root == null) System.out.println("Tree is Empty!");
				else {
					sb = new StringBuilder();
					System.out.println("For which element do you want to see the successor?");
					userBST.traversePreOrder(sb, "", "", userBST.root);
					System.out.print(sb.toString());
					int successorNode = 0;
					String userSuccessorNode = scan.nextLine();
					if(isNumber(userSuccessorNode)) {
						successorNode = Integer.parseInt(userSuccessorNode);
						if(userBST.treeSearch(userBST.root,successorNode) == null) System.out.println("Element not on the tree!");
						else System.out.println("Successor of ["+successorNode+"] is :"+userBST.treeSuccessor(userBST.treeSearch(userBST.root,successorNode)).data);
					}
				}
				break;
			case 6:
				if(userBST.root == null) System.out.println("Tree is Empty!");
				else userBST.inorderTreeWalk(userBST.root);
				System.out.println("");
				break;
			case 7:
				if(userBST.root == null) System.out.println("Tree is Empty!");
				else {
					sb = new StringBuilder();
					userBST.traversePreOrder(sb, "", "", userBST.root);
					System.out.print(sb.toString());
				}
				break;
			case 8:
				displayMainMenu();
				break;
			default:
				System.out.println("Invalid Input, Please Choose again");
				break;
			}
		}
		BSTHandler();	
	}
	
	/** Builds a Heap object 
	 * 
	 */
	private static void heapBuilder() {
		userHeap = new Heap(userTempArray);
	}
	
	/** Handles all operations to be performed on the saved Heap object through user input from the terminal
	 * 
	 */
	private static void heapHandler() {
		System.out.println("-**Heap Operations**-");
		System.out.println("Build Max Heap	-> 1");
		System.out.println("Build Min Heap	-> 2");
		System.out.println("HeapSort	-> 3");
		System.out.println("Main Menu	-> 4");
		
		int heapOp = 0;
		String userHeapOp = scan.nextLine();
		if(isNumber(userHeapOp)) {
			heapOp = Integer.parseInt(userHeapOp);
		}else heapHandler();
		switch(heapOp) {
		case 1:
			userHeap.buildMaxHeap(userHeap);
			System.out.print("Max Heap: ");
			for(int i=0;i<userHeap.heap.length;i++) {
				System.out.print("["+i+"]: "+userHeap.heap[i]+" ");
			}
			System.out.println("");
			heapHandler();
			break;
		case 2:
			userHeap.buildMinHeap(userHeap);
			System.out.print("Min Heap: ");
			for(int i=0;i<userHeap.heap.length;i++) {
				System.out.print("["+i+"]: "+userHeap.heap[i]+" ");
			}
			System.out.println("");
			heapHandler();
			break;
		case 3:
			userHeap.heapSort(userHeap);
			System.out.print("Sorted Heap: ");
			for(int i=0;i<userHeap.heap.length;i++) {
				System.out.print("["+i+"]: "+userHeap.heap[i]+" ");
			}
			System.out.println("");
			heapHandler();
			break;
		case 4:
			displayMainMenu();
			break;
		default:
			BSTHandler();
			break;
		}
	}
	
	/** Builds a Huffman Tree object
	 * 
	 */
	private static void huffmanBuilder() {
		userHuffman = new Huffman();
	}
	
	/** Handles generating a huffman tree with user input from the terminal
	 * 
	 */
	private static void huffmanHandler() {
		System.out.println("Enter a string");
		String userHuff = scan.nextLine();
		if(userHuff == null) {
			System.out.println("You need to write something!");
			displayMainMenu();
		}else {
			userHuffman.huffman(userHuff);
			System.out.println("");
			displayMainMenu();
		}
	}
	
	/** Sorts a passed array using insertion sort
	 * 
	 * @param array Array to be sorted
	 */
	public static void insertionSort(int[] array) {
		System.out.println("--Original Array--");
		printArray(array);
		for(int j=0;j<array.length;j++) {
			int key = array[j];
			int i = j-1;
			while (i>=0 && array[i] > key) {
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
		System.out.println("--Insertion Sorted Array--");
		printArray(array);
		displayMainMenu();
	}
	
	/** Sorts the user defined array based on Merge Sort, the taught pseudocode did not work, and was using sentinels
	 * I will explain the differences on how this implementation works during the study group if you have questions.
	 * 
	 * @param arrIn Array to be sorted
	 * @param x Array length
	 */
	public static void mergeSort(int[] arrIn,int x){
		if(x < 2) return;
		int mid = Math.floorDiv(x,2);
		int[] left = new int[mid];
		int[] right = new int[x-mid];
		for(int i=0;i<x;i++) {
			if(i<mid) left[i] = arrIn[i];
			else right[i-mid] = arrIn[i];
		}
		
		mergeSort(left,mid);
		mergeSort(right,x-mid);
		merge(arrIn,left,right);
	}
	
	/** Merges the segments generated by {@link #mergeSort(int[], int)}r
	 * 
	 * @param arrIn Array that will hold the sorted segment
	 * @param left Left segment of array
	 * @param right Right segment of array
	 */
	private static void merge(int[] arrIn,int[] left,int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) arrIn[k++] = left[i++];
			else arrIn[k++] = right[j++];
		}
		while (i < left.length) arrIn[k++] = left[i++];
		while (j < right.length) arrIn[k++] = right[j++];
	}
	
	public static void quickSort(int[] arrIn,int start,int end) {
		if(start < end) {
			int mid = partition(arrIn,start,end);
			quickSort(arrIn,start,mid-1);
			quickSort(arrIn,mid+1,end);
		}
	}
	
	private static int partition(int[] arrIn,int start,int end) {
		int x = arrIn[end];
		int i = (start-1);
		for(int j=start;j<end;j++) {
			if(arrIn[j] <= x) {
				i++;
				int tmp = arrIn[i];
				arrIn[i] = arrIn[j];
				arrIn[j] = tmp;
			}
		}
		int tmp2 = arrIn[i+1];
		arrIn[i+1] = arrIn[end];
		arrIn[end] = tmp2;
		return i+1;
	}
	
	/** Prints the passed array
	 * 
	 * @param arrIn Array to be printed
 	 */
	private static void printArray(int[] arrIn) {
		for(int i=0;i<arrIn.length;i++) {
			System.out.print("["+i+"]: "+arrIn[i]+" ");
		}
		System.out.println("");
	}
	
	/** Validates if user input is number and informs the user.
	 * 
	 * @param userInput Any user input from the menu prompts
	 * @return boolean
	 */
	private static boolean isNumber(String userInput) {
		try{
			Integer.parseInt(userInput);
			return true;
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            return false;
        }
	}
	


}

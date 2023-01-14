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
	
	static StringBuilder sb = new StringBuilder();
	
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
				if(userTempArray == null) {
					System.out.println("Define an array first by choosing 11");
					displayMainMenu();
				}
				break;
			case 6:
				System.out.println("To be added!");
				displayArrayMenu();
				break;
			case 7:
				if(userTempArray == null) displayArrayMenu();
				heapBuilder();
				heapHandler();
				break;
			case 8:
				System.out.println("To be added!");
				displayArrayMenu();
				break;
			case 9:
				System.out.println("To be added!");
				displayArrayMenu();
				break;
			case 10:
				System.out.println("Bye Bye!");
				appRunning = false;
				break;
			default:
				System.out.println("Invalid Input Please choose again!");
				displayMainMenu();
			}
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            displayMainMenu();
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
				displayArrayMenu();
				break;
			}
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            displayArrayMenu();
        }
		
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
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid Input, Please Choose again");
            arrayCreateHandler();
        }
		
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
	
	/** Displays the user saved array
	 * 
	 */
	private static void arrayDisplayHandler() {
		if(userTempArray == null) {
			System.out.println("No array defined");
			displayArrayMenu();
		}else {
			System.out.println("--Showing Array--");
			for(int i=0;i<userTempArray.length;i++) {
				System.out.print(" ["+i+"]: "+userTempArray[i]);
			}
			System.out.println("");
			displayArrayMenu();
		}

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
			}else {
				stackHandler();
			}
			
		} 
		userStack = new Stack(stackSize);
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
		}else {
			stackHandler();
		}
		switch(stackOp) {
		case 1:
			System.out.println("Enter a number: ");
			int element = 1;
			String userElement = scan.nextLine();
			if(isNumber(userElement)) {
				element = Integer.parseInt(userElement);
			}else {
				stackHandler();
			}
			userStack.push(element);
			stackHandler();
			break;
		case 2:
			System.out.println("Removed "+userStack.pop());
			stackHandler();
			break;
		case 3:
			userStack.printStack();
			stackHandler();
			break;
		case 4:
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid Input, Please Choose again");
			stackHandler();
		}
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
			}else {
				stackHandler();
			}
		} 
		userQueue = new Queue(queueSize);
		
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
			int element = 1;
			String userElement = scan.nextLine();
			if(isNumber(userElement)) {
				element = Integer.parseInt(userElement);
				userQueue.enqueue(element);
			}
			queueHandler();
			break;
		case 2:
			System.out.println("Removed "+userQueue.dequeue());
			queueHandler();
			break;
		case 3:
			userQueue.printQueue();
			queueHandler();
			break;
		case 4:
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid Input, Please Choose again");
			queueHandler();
		}
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
		}else {
			queueHandler();
		}
		switch(linkedListOp) {
		case 1:
			System.out.println("Enter a number: ");
			int element = 1;
			String userElement = scan.nextLine();
			if(isNumber(userElement)) {
				element = Integer.parseInt(userElement);
				userLinkedList.addNode(element);
			}
			linkedListHandler();
			break;
		case 2:
			System.out.println("Enter a number: ");
			element = 1;
			userElement = scan.nextLine();
			if(isNumber(userElement)) {
				element = Integer.parseInt(userElement);
				userLinkedList.removeNode(element);
			}
			linkedListHandler();
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
			linkedListHandler();
			break;
		case 4:
			userLinkedList.printLinkedList();
			linkedListHandler();
			break;
		case 5:
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid Input, Please Choose again");
			linkedListHandler();
		}
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
		}else {
			BSTHandler();
		}
		switch(BSTOp) {
		case 1:
			System.out.println("Enter the element you want to add: ");
			int addNode = 0;
			String useraddNode = scan.nextLine();
			if(isNumber(useraddNode)) {
				addNode = Integer.parseInt(useraddNode);
				userBST.addNode(addNode);
				BSTHandler();
			}else {
				BSTHandler();
			}
			break;
		case 2:
			if(userBST.root == null) {
				System.out.println("Tree Empty!");
				BSTHandler();
			}else {
				System.out.println("Which Element do you want to delete?");
				userBST.traversePreOrder(sb, "", "", userBST.root);
				System.out.print(sb.toString());
				int delNode = 0;
				String userdelNode = scan.nextLine();
				if(isNumber(userdelNode)) {
					delNode = Integer.parseInt(userdelNode);
					if(userBST.treeSearch(userBST.root,delNode) == null) {
						System.out.println("Element not on the tree!");
						BSTHandler();
					}else {
						userBST.treeDelete(userBST, userBST.treeSearch(userBST.root,delNode));
						System.out.println("Element Deleted!");
						BSTHandler();
					}
				}else {
					BSTHandler();
				}
			}
			break;
		case 3:
			if(userBST.root == null)System.out.println("Tree is Empty!");
			else System.out.println("Tree min is: "+userBST.treeMin(userBST.root).data);
			BSTHandler();
			break;
		case 4:
			if(userBST.root == null)System.out.println("Tree is Empty!");
			else System.out.println("Tree max is: "+userBST.treeMax(userBST.root).data);
			BSTHandler();
			break;
		case 5:
			if(userBST.root == null) System.out.println("Tree is Empty!");
			else {
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
				BSTHandler();
			}
			BSTHandler();
			break;
		case 6:
			if(userBST.root == null) System.out.println("Tree is Empty!");
			else userBST.inorderTreeWalk(userBST.root);
			System.out.println("");
			BSTHandler();
			break;
		case 7:
			if(userBST.root == null) System.out.println("Tree is Empty!");
			else {
				userBST.traversePreOrder(sb, "", "", userBST.root);
				System.out.print(sb.toString());
			}
			BSTHandler();
			break;
		case 8:
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid Input, Please Choose again");
			BSTHandler();
			break;
		}
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
	
	/** Validates if user input and informs the user.
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
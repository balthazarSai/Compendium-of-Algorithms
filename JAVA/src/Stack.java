/**
 * 
 * @author balthazarSai
 * @date 18 Jan 2023
 *
 */
public class Stack {
	int stackPointer = -1;;
	int[] stack;
	
	/** The Stack class constructor
	 *  
	 * @param stackSize The size of the stack to be created
	 */
	public Stack(int stackSize){
		stack = new int[stackSize];
	}
	
	/** Adds an element to the top of the stack
	 * 
	 * @param element An integer value to be added
	 */
	public void push(int element) {
		if(!checkOverflow()) {
			++stackPointer;
			stack[stackPointer] = element;
		}
	}
	
	/** Removes the element at the {@link #stackPointer} index position of the stack
	 * 
	 * @return Returns the removed element.
	 */
	public int pop() {
		if(!checkUnderflow()) {
			int tmp = stack[stackPointer];
			stackPointer--;
			return tmp;
		}else return 0;
			
	}
	
	/** Prints the stack
	 * 
	 */
	public void printStack() {
		for(int i=0;i<stack.length;i++) {
			if(i <= stackPointer) {
				System.out.println(" ["+i+"]: "+stack[i]);
			}else {
				System.out.println(" ["+i+"]: #");
			}
			
		}
	}
	
	/** Checks if the stack is full and returns a T/F value
	 * 
	 * @return Returns true if stack is full
	 */
	public boolean checkOverflow() {
		if(stackPointer+1 >= stack.length) {
			System.out.println("Stack Overflow");
			return true;
		}else return false;
	}
	
	/** Checks if the stack is empty and returns a T/F value
	 * 
	 * @return Returns true if stack is empty
	 */
	public boolean checkUnderflow() {
		if(stackPointer-1 < -1) {
			System.out.println("Stack Underflow");
			return true;
		}else return false;
	}
}
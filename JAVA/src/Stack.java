
public class Stack {
	int stackPointer = -1;;
	int[] stack;
	
	public Stack(int stackSize){
		stack = new int[stackSize];
	}
	
	public void push(int element) {
		if(!checkOverflow()) {
			++stackPointer;
			stack[stackPointer] = element;
		}
	}
	
	public int pop() {
		if(!checkUnderflow()) {
			int tmp = stack[stackPointer];
			stackPointer--;
			return tmp;
		}else return 0;
			
	}
	
	public void printStack() {
		for(int i=0;i<stack.length;i++) {
			if(i <= stackPointer) {
				System.out.println(" ["+i+"]: "+stack[i]);
			}else {
				System.out.println(" ["+i+"]: #");
			}
			
		}
	}
	
	public boolean checkOverflow() {
		if(stackPointer+1 >= stack.length) {
			System.out.println("Stack Overflow");
			return true;
		}else return false;
	}
	
	public boolean checkUnderflow() {
		if(stackPointer-1 < -1) {
			System.out.println("Stack Underflow");
			return true;
		}else return false;
	}
}
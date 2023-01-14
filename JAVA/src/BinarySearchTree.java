

public class BinarySearchTree {
	Node root = null;

	static class Node{
		int data;
		Node parent;
		Node left;
		Node right;
		
		public Node(int value) {
			data = value;
		}
	}
	
	public void addNode(int value) {
		Node newNode = new Node(value);
		Node y = null;
		Node x = root;
		while(x != null) {
			y = x;
			if(newNode.data < x.data) {
				x = x.left;
			}else x = x.right;
		}
		newNode.parent = y;
		if (y == null) root = newNode;
		else if(newNode.data < y.data) y.left = newNode;
		else y.right = newNode;
	}
	
	public Node treeSearch(Node current,int target) {
		if(current == null || target == current.data) return current;
		if(target < current.data) return treeSearch(current.left,target);
		else return treeSearch(current.right,target);
	}
	
	public Node treeMin(Node current) {
		while(current.left != null) {
			current = current.left;
		};
		return current;
	}
	
	public Node treeMax(Node current) {
		while(current.right != null) {
			current = current.right;
		};
		return current;
	}
	
	public Node treeSuccessor(Node current) {
		if(current.right != null) return treeMin(current.right);
		Node y = current.parent;
		while(y != null && current == y.right) {
			current = y;
			y = y.parent;
		}
		return y;
	}
	
	public void inorderTreeWalk(Node current) {
		if(current != null) {
			inorderTreeWalk(current.left);
			System.out.print("["+current.data+"] ");
			inorderTreeWalk(current.right);
		}
	}
	
	public void transplant(BinarySearchTree tree,Node u, Node v) {
		if(u.parent == null) tree.root = v;
		else if(u == u.parent.left) u.parent.left = v;
		else u.parent.right = v;
		if (v != null) v.parent = u.parent;
	}
	
	public void treeDelete(BinarySearchTree tree,Node target) {
		Node y;
		if(target.left == null) transplant(tree,target,target.right);
		else if(target.right == null) transplant(tree,target,target.left);
		else {
			y = treeMin(target.right);
			if(y.parent != target) {
				transplant(tree,y,y.right);
				y.right = target.right;
				y.right.parent = y;
			}
			transplant(tree,target,y);
			y.left = target.left;
			y.left.parent = y;
		}
	}
	
	/** Copied from https://www.baeldung.com/java-print-binary-tree-diagram and modified for use here:
	 * Prints the Binary Search Tree
	 * 
	 * @param sb
	 * @param padding
	 * @param pointer
	 * @param current
	 */
	public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node current) {
	    if (current != null) {
	        sb.append(padding);
	        sb.append(pointer);
	        sb.append(current.data);
	        sb.append("\n");

	        StringBuilder paddingBuilder = new StringBuilder(padding);
	        paddingBuilder.append("|  ");

	        String paddingForBoth = paddingBuilder.toString();
	        String pointerForRight = "\\--";
	        String pointerForLeft = "/--";

	        traversePreOrder(sb, paddingForBoth, pointerForLeft, current.left);
	        traversePreOrder(sb, paddingForBoth, pointerForRight, current.right);
	    }
	}

}


/**
 * 
 * @author BalthazarSai
 * @date 16 Jan 2023
 */
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
	
	/** Constructs an object of the class Node and adds it to the Binary Search Tree respecting all properties.
	 * 
	 * @param value An integer value that the Node will contain
	 */
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
	
	/** This algorithm will search through the Binary Tree to find a given node. This is used mainly to get a Node based on user input so it can be used on other functions.
	 * 
	 * @param current Starting Node from which the algorithm will start searching through the tree
	 * @param target Target Node which the algorithm is looking to match
	 * @return Returns the found node or null if the Node was not found
	 */
	public Node treeSearch(Node current,int target) {
		if(current == null || target == current.data) return current;
		if(target < current.data) return treeSearch(current.left,target);
		else return treeSearch(current.right,target);
	}
	
	/** Finds the minimum element on the tree based on a starting Node
	 * 
	 * @param current Usually this is the root Node, although it can be a different Node that will provide the min of a subtree
	 * @return Returns the Node holding the minimum element of the Binary Search Tree
	 */
	public Node treeMin(Node current) {
		while(current.left != null) {
			current = current.left;
		};
		return current;
	}
	
	/** Finds the maximum element on the tree based on a starting Node
	 * 
	 * @param current Usually this is the root Node, although it can be a different Node that will provide the max of a subtree
	 * @return Returns the Node holding the maximum element of the Binary Search Tree
	 */
	public Node treeMax(Node current) {
		while(current.right != null) {
			current = current.right;
		};
		return current;
	}
	
	/** Finds the successor of a given node in a Binary Search Tree
	 * 
	 * @param current The target Node for which we want to find the successor
	 * @return
	 */
	public Node treeSuccessor(Node current) {
		if(current.right != null) return treeMin(current.right);
		Node y = current.parent;
		while(y != null && current == y.right) {
			current = y;
			y = y.parent;
		}
		return y;
	}
	
	/** Prints the tree in numerical order from smaller to larger.
	 * 
	 * @param current The starting Node, should be root
	 */
	public void inorderTreeWalk(Node current) {
		if(current != null) {
			inorderTreeWalk(current.left);
			System.out.print("["+current.data+"] ");
			inorderTreeWalk(current.right);
		}
	}
	
	/** Swaps 2 Nodes in order to perform a deletion operation, is only called privately through {@link #treeDelete(BinarySearchTree, Node)}
	 * 
	 * @param tree The tree on which to perform the operation
	 * @param u The first Node
	 * @param v The second Node
	 */
	private void transplant(BinarySearchTree tree,Node u, Node v) {
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
	
	/** Prints the Binary Search Tree. Modified from original on Baedlung to work here.
	 *  A sample starting format for this would be {@code userBST.traversePreOrder(sb, "", "", root);}
	 * 
	 * @param sb The string builder object to be passed
	 * @param padding The left, right, or straight indicators for the tree created by the stringbuilder
	 * @param pointer Indicates which direction the child will be 
	 * @param current The starting Node
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

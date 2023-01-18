import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
	Map<Character,Integer> letterNodes = new HashMap<>();
	PriorityQueue<Node> remainingNodes = new PriorityQueue<>(Comparator.comparingInt(l -> l.frequency));
	
	class Node{
		int frequency;
		Node left,right = null;
		char character;
		
		/** The Node subclass constructor
		 * 
		 * @param character
		 * @param frequency
		 */
	    private Node(Character character, Integer frequency)  
	    {  
	        this.character = character;  
	        this.frequency = frequency;  
	    }
		
	    /** The Node subclass constructor
	     * 
	     * @param character Character to be held by the Node
	     * @param frequency Frequency to be heal by the Node
	     * @param left The left child of the Node
	     * @param right The right child of the Node
	     */
		private Node(Character character, Integer frequency, Node left, Node right)  
	    {  
	        this.character = character;  
	        this.frequency = frequency;  
	        this.left = left;  
	        this.right = right;  
	    }
	}
	
	/** Receives a string from the user and builds a Huffman tree
	 * 
	 * @param input A string to be converted into a Huffman tree
	 */
	public void huffman(String input) {
		for (char character: input.toCharArray()){
            letterNodes.put(character, letterNodes.getOrDefault(character, 0) + 1);  
        }
		
		for(var entry:letterNodes.entrySet()) {
			remainingNodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		
		while(remainingNodes.size()!=1) {
            Node left = remainingNodes.poll();  
            Node right = remainingNodes.poll();  
            int newFreq = left.frequency + right.frequency;
            remainingNodes.add(new Node(' ', newFreq, left, right));
		}
		
		  Node root = remainingNodes.peek();  
	      Map<Character, String> huffman = new HashMap<>();  
	      huffmanEncode(root, "", huffman);
	      System.out.println("Characters & Frequencies : " + letterNodes);
	      System.out.println("Huffman Codes : " + huffman); 
	}
	
	/** Encodes the tree to give out the new variable 0,1 codes
	 * 
	 * @param root The root Node
	 * @param str A string object to place the codes in
	 * @param huffmanCode The hashmap that maps codes to corresponding letters.
	 */
	public static void huffmanEncode(Node root, String str, Map<Character, String> huffmanCode)  
    {  
        if (root == null)return;   
        if (root.left == null && root.right == null)   
        {  
            huffmanCode.put(root.character, str.length() > 0 ? str : "1");  
        }  
        huffmanEncode(root.left, str + '0', huffmanCode);  
        huffmanEncode(root.right, str + '1', huffmanCode);  
    }  
	
	
	
}

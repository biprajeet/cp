package cp.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {

	class Node {
	int data;
	Node left;
	Node right;
	}
	
	public static void levelOrder(Node root) {
	      
		Queue<Node> queue =  new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
	      
    }
}

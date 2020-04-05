package cp.practice;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {

	public class Node{
		int data;
		Boolean marked;
		Node[] adjacent;
	}
	
	void search(Node n) {
		
	Queue<Node> queue =  new LinkedList<Node>();
	n.marked = true;
	queue.add(n);
	
	while(!queue.isEmpty()) {
		Node temp = queue.remove();
		for (int i = 0; i < temp.adjacent.length; i++) {
			temp.adjacent[i].marked = true;
			queue.add(temp.adjacent[i]);
		}
	}
  }
}

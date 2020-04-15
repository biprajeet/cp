package cp.practice;

import java.util.ArrayList;
import java.util.List;

public class llofdepths {

	public class Node{
		int data;
		Node left;
		Node right;
	}
	
	List<List<Node>> createAListOfListOfDepths(Node n) {
		
		if(n==null) return null;
		
		List<List<Node>> list = new ArrayList<>();
		int i = 0;
		
		List<Node> tempList = new ArrayList<>();
		tempList.add(n);
		list.add(tempList);
		
		while(i != list.size()) {
			
			List<Node> temp = list.get(i++);
			List<Node> temp2 = new ArrayList<>();
			
			for (int j = 0; j < temp.size(); j++) {
				
				Node t = temp.get(j);
				if(t.left != null) {
					temp2.add(t.left);
				}
				if(t.right != null) {
					temp2.add(t.right);
				}
			}
			
			if(!temp2.isEmpty()) list.add(temp2);
		}
		return list;
	}
	
}

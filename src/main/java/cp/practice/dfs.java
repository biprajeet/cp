package cp.practice;

public class dfs {

	public class Node {
		int data;
		Boolean marked;
		Node[] adjacent;
	}

	void search(Node n) {

		if (n == null)
			return;

		n.marked = true;
		System.out.println(n.data);

		for (Node s : n.adjacent) {
			
			if(s.marked == false)
			search(s);
		}

	}

}

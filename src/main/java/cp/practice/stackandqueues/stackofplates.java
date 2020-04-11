package cp.practice.stackandqueues;

import java.util.ArrayList;
import java.util.List;

class Sop{
	
	List<List<Integer>> list;
	int max;

	public Sop(int maxLengthOfStack) {
		list  = new ArrayList<>();
		list.add(new ArrayList<Integer>());
		max = maxLengthOfStack;
	}
	
	public void push(int x) {
		if(list.get(list.size()-1).size()>=max) 
			list.add(new ArrayList<Integer>());
		list.get(list.size()-1).add(x);
	}
	
	public int pop() {
		return list.get(list.size()-1).remove(list.get(list.size()-1).size()-1);
	}
	
	public int popFromPStack(int stacknumber) {
		return list.get(stacknumber).remove(list.get(list.size()-1).size()-1);
	}
	
}

public class stackofplates {

	public static void main(String[] args) {
		Sop s = new Sop(3);
		int i = 0;
		while(i++<12) {
			s.push(i);
		}
		System.out.println(s.pop());
		System.out.println(s.popFromPStack(2));
	}
	
}


package cp.practice;

import java.util.LinkedList;
import java.util.List;

public class ListofprimesSieveOfEratosthenes {

	public void printAllPrimeTillUpperlimit(int n) {
		
		List<Integer> l = new LinkedList<>();
		
		for (int i = 0; i <= n; i++) {
			
			l.add(i);
			
		}
		
		System.out.println(l);
		
		for (int i = 2; i < n; i++) {
			
			for (int j = i+1; j < l.size(); j++) {
				
				if(l.get(j) % i ==0) l.remove(j);
				
			}
			
		}
		
		l.remove(0);l.remove(0);
		System.out.println(l);
		
	}
	
	public static void main(String[] args) {
		ListofprimesSieveOfEratosthenes l = new ListofprimesSieveOfEratosthenes();
		l.printAllPrimeTillUpperlimit(41);
	}
}

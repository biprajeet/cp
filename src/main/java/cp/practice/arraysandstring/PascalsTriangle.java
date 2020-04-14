package cp.practice.arraysandstring;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(numRows >= 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			res.add(temp);
		}
		
		if(numRows >= 2) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);temp.add(1);
			res.add(temp);
		}
		
		for (int i = 3; i <= numRows; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
				
				List<Integer> prev = res.get(i-2);
				for (int j = 0; j < prev.size()-1; j++) {
					temp.add(prev.get(j)+prev.get(j+1));
				}
			
			temp.add(1);
			res.add(temp);
		}
		
		return res;
    }
	
	public List<List<Integer>> generate2(int numRows) {
	
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = new ArrayList<>();
			
				// more 11 powers with no carrying using BIG INTEGER but will require extra space
			
			res.add(temp);
		}
		
		
		return res;
	}
}

package cp.practice.leetcode30day.leftcolumnwithatleastOne;

import java.util.List;

class Solution {

	interface BinaryMatrix {
		public int get(int x, int y);
		public List<Integer> dimensions();
	};

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		
		List<Integer> d = binaryMatrix.dimensions();
		int rows = d.get(0);
		int columns = d.get(1);
		
		int x = 0;
		int y = columns - 1;
		
		int value = 0;
            
        int lastseenone = -1;    
		
		while(x != rows && y!= -1) {
			
			value = binaryMatrix.get(x, y);
			
			//if 0 go down 
			if(value == 0) {
				x++;
			}
			//if 1 go left
			else {
				lastseenone = y;
                y--;
			}
			
		}
		
		return lastseenone;
	}
}
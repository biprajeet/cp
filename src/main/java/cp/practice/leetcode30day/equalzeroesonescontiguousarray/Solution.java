package cp.practice.leetcode30day.equalzeroesonescontiguousarray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> diffs = new HashMap<>(); 
        
        int count_0 = 0;
        int count_1 = 0;
        
        Integer s;
        
        diffs.put(0, -1);
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
			
        	if(nums[i] == 0)
        		count_0++;
        	else 
        		count_1++;
        	
        	s = diffs.get(count_1-count_0);
        	
        	if(s!= null) {
        		result = (i-s)>result ? (i-s): result;
        	}
        	else {
        		diffs.put(count_1-count_0, i);
        	}
		}
    	return result;
    }
    
    public static void main(String[] args) {
		int a[] = {0,1,0,1,0,1,0};
		System.out.println(findMaxLength(a));
	}
}

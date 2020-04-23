package cp.practice.leetcode30day.subarrayequalssumk;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxSubArray(int[] nums, int k) {
		int count = 0;
		
		Map<Integer, Integer> mapOfDiffFrequencies = new HashMap<>();
		
		Integer currentSum = 0, getResult;
		
		mapOfDiffFrequencies.put(currentSum, 1);
		
		for (int i = 0; i < nums.length; i++) {
			
			currentSum += nums[i];
			
			getResult = mapOfDiffFrequencies.get(currentSum - k);
			
			if(getResult != null) {
				count+=getResult;
			}
			
			getResult = mapOfDiffFrequencies.get(currentSum);
			mapOfDiffFrequencies.put(currentSum, getResult==null? 1 : getResult+1);
			
		}	
		
		return count;
	}
}
package cp.practice.leetcode30day.countingelements;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countElements(int[] arr) {
        int[] count = new int[1001]; 
        int sum =0;
    	for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
    	for (int i = 0; i < count.length-1; i++) {
			if(count[i]>0 && count[i+1]>0)
				sum+= count[i];
		}
    	return sum;
    }
    /**
     * alternate solution using hashset
     * 
     * @param arr
     * @return
     */
    public int countElements2(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        int sum =0;int i;
    	for (i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
    	for (i = 0; i < arr.length; i++) {
			if(set.contains(arr[i]+1))
				sum++;
		}
    	return sum;
    }
}
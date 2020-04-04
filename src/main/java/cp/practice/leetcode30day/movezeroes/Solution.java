package cp.practice.leetcode30day.movezeroes;

class Solution {
	 public static void moveZeroes(int[] nums) {
	     int i,j = 0;
		 for (i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				if(i!=j) nums[j] = nums[i];
 				j++;
			}			
		}
		for(i=j;i<nums.length;i++) {
			nums[i]=0;
		} 
	 }
    
    public static void main(String[] args) {
    	int a[] = {0,1,0,3,12};
    	moveZeroes(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
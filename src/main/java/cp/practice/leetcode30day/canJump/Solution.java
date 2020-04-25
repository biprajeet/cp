package cp.practice.leetcode30day.canJump;

class Solution {
    public boolean canJump(int[] nums) {
        
    	int count = 0;
    	boolean isZeroFound = false;
    	
    	for (int i = nums.length-2; i >-1; i--) {
			    		
			if (isZeroFound) {
				if (nums[i] <= count) {
					count++;
				}
				else {
					count = 0;
					isZeroFound = false;
				}
			}
			else if(nums[i] == 0) {
    			count = 1;
    			isZeroFound = true;
    		}
		}
    	return !isZeroFound;
    }
    
    public static void main(String[] args) {
		int a[] =  {2,0,0};
    	Solution s = new Solution();
		System.out.println(s.canJump(a));
	}
}


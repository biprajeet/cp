package cp.practice.leetcode30day.maximumsubarray;

class Solution {
    public int maxSubArray(int[] nums) {
            int i,largestsum=nums[0],currentsum=nums[0];
        for(i=1;i<nums.length;i++){
            currentsum = Math.max(nums[i], currentsum+nums[i]);
            largestsum = Math.max(largestsum,currentsum);
        }
        return largestsum;
    }
}
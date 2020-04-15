package cp.practice.leetcode30day.productOfArrayExceptSelf;

class Solution {
	public static int[] productExceptSelf(int[] nums) {

		int product = 1, i;
		int[] output = new int[nums.length];
		
		for (i = 0; i < nums.length; i++) {
			output[i] = product;
			product *= nums[i]; 
		}
		
		product = 1;
		
		for (i = nums.length - 1; i >= 0; i--) {
			output[i] *= product;
			product *= nums[i];
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		int a[] = {5,2,3,4};
		a = productExceptSelf(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
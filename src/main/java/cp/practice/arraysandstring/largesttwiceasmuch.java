package cp.practice.arraysandstring;

public class largesttwiceasmuch {

	
	public static int dominantIndex(int[] nums) {
     
		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;
		int returnIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			
			if(nums[i]> largest) {secondlargest = largest; largest = nums[i];  returnIndex = i;}
			else if(nums[i]> secondlargest) secondlargest = nums[i];
			
		}
		if(secondlargest*2<= largest)
			return returnIndex;
		else 
			return -1;
    }
	
	public static void main(String[] args) {
		int a[] = {3, 6, 1, 0};
		System.out.println(dominantIndex(a));
	}
}

package cp.practice.arraysandstring;

public class Findpivotindex {

	public int pivotIndex(int[] nums) {
        int i, sum = 0, a, b;
        for (i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
        a = 0; b = sum;
        for (i = 0; i < nums.length; i++) {
        	if(i!=0) a = a + nums[i-1];
        	b= b - nums[i];
        	if(a == b) return i;   	
		}
        return -1;
    }
}

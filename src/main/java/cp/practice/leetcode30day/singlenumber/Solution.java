package cp.practice.leetcode30day.singlenumber;

import java.util.Arrays;

class Solution {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i+=2) {
			if(nums[i]!=nums[i+1]) return nums[i];
		}
        return nums[nums.length-1];
    }
    
    public int firstUniqChar(String s) {
    	int a[] =new int[26];
    	int i;
        for(i=0;i<s.length();i++){
            a[s.charAt(i)-97]++;
        }
        for(i=0;i<s.length();i++){
            if(a[s.charAt(i)-97] == 1) return i;
        }
        return -1;
    }
    
	public int trap(int[] height) {
        
        int left =0, right = height.length -1, ans =0, left_max=0, right_max=0;
        		
        while(left<right) {
        	
        	if(height[left]<height[right]) {
        		
        		if(height[left] >= left_max ) left_max = height[left] ;
        		else ans += (left_max-height[left]); 
        		++left;
        		
        	}
        	else {
        		
        		 if( height[right] >= right_max )
        			 right_max = height[right] ;
        		else ans += (right_max - height[right]);
                  --right;
        	}
        	
        	
        }	
        return ans;
    }

    public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {4,1,2,1,2}));
	}
}

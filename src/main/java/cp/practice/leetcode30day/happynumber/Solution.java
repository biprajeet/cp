package cp.practice.leetcode30day.happynumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static boolean isHappy(int n) {
        List<Integer> l = new ArrayList<Integer>();
        int f;
        while(n!=1 && !l.contains(n)){
        	l.add(n);
            f = n;
            n = 0;
            while(f>0)
            {
                n+=(f%10)*(f%10);
                f/=10;
            }
        }
        if(n==1) return true;
        else return false;
        
    }
    
    public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
package cp.practice.leetcode30day.rangeBitwiseAnd;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int rangeBitwiseAnd1(int m, int n) {
    	  	
    	int arr[] = new int[Integer.toBinaryString(n).length()];
    	
    	for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
    	
    	for (int i = n; i >= m; i--) {
			
    		String res = Integer.toBinaryString(i);
    		
    		int k = arr.length - 1;
    		int l = res.length() - 1;
    		
    		while(k>=0) {
    			
    			if(arr[k] != 0) {
    				if(l<0 || res.charAt(l) == '0') arr[k] =0;
    			}	
    			l--;k--;	
    		}
    		
		}
    	
    	StringBuilder s = new StringBuilder();
    	
    	for (int i = 0; i < arr.length; i++) {
			s.append(arr[i]);
		}
    	
        return Integer.parseInt(s.toString(),2);
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.rangeBitwiseAnd(2147483646,2147483647));
	}
    
    public int rangeBitwiseAnd2(int m, int n) {
	  	
    	String ms = Integer.toBinaryString(m);
    	
    	List<Integer> listOfones = new LinkedList<>();
    	
    	int lengthOfM = ms.length();
    	
    	for (int i = lengthOfM-1; i >= 0; i--) {
			
    		if(ms.charAt(i)=='1') listOfones.add(i);
    		
		}
    	    	
    	while(++m<=n && !listOfones.isEmpty()) {
    		
    		ms = Integer.toBinaryString(m);
    		
    		int diff = ms.length() - lengthOfM; 
    		
    		for (int i = 0; i < listOfones.size(); i++) {
				if(ms.charAt(listOfones.get(i)+diff) == '0') listOfones.remove(i--);
			}
    		
    		//System.out.println(m + " " + ms + " " + listOfones + " " + diff);
    	}
    	
    	if(listOfones.isEmpty()) return 0;
    	else {
    		
    		
    		int arr[] = new int[lengthOfM];
    		
    		for (Integer i : listOfones) {
				arr[i] = 1;
			}
    		
    		StringBuilder s = new StringBuilder();
    		
    		for (int i = 0; i < arr.length; i++) {
				s.append(arr[i]);
			}
    		
    		return Integer.parseInt(s.toString() ,2);
    	} 
    }
    
    public int rangeBitwiseAnd(int m, int n) {
    	
    	String ms = Integer.toBinaryString(m);
    	
    	int lengthOfM = ms.length();
    	
    	int temp = 0;
    	
    	int arr[] = new int[lengthOfM+1];
    	
    	for (int i = 0; i < lengthOfM; i++) {
			
    		if(ms.charAt(i)=='1') arr[i+1] = 1;
    		
		}
    	    	
    	for (int i = arr.length - 1 ; i >= 0; i--) {
			
    		if(arr[i] == 1) {

        		StringBuilder s = new StringBuilder();
        		
        		for (int j = 0; j < arr.length; j++) {
        			
        			if(j == (i -1)) s.append(1);
        			else if ( j >= i) s.append(0);
        			else s.append(arr[j]);
    			}
        		
        		
        		
        		try {
        			temp = Integer.parseInt(s.toString() ,2);
        			if (temp >= m && temp <= n) {
            			
            			for (int j = i; j < arr.length; j++) {
    						arr[j] =0;
    					}
            			
            		}
        		}catch (NumberFormatException e) {
					
				}
        		
        		
        		

    		}
    		
		}
    	
    	StringBuilder s = new StringBuilder();
		
		for (int j = 0; j < arr.length; j++) {
			s.append(arr[j]);
		}
		
		return Integer.parseInt(s.toString() ,2);
    } 
}
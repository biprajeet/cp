package cp.practice.leetcode30day.backspacestringcompare;

class Solution {
    public static boolean backspaceCompare(String S, String T) {
        
        int sb=0, tb=0;
        char sc, tc;
        int i=S.length()-1;
        int j=T.length()-1;
        
        while(i>=0 || j>=0) {
        	
        	sc = i>=0 ? S.charAt(i):'?';
        	tc = j>=0 ? T.charAt(j):'?';
        	
        	if(sc == tc && sb ==0 && tb == 0) {
        		i--;
        		j--;
        		if(sc == '#') {
            		sb++; tb++;
            	}
        	}
        	else if(sc == tc && sb>0) {
        		while(sb > 0 && i>=0) {
        			if(S.charAt(i)!='#') sb--;
        			else sb++;
        			i--;
        		}
        	}
        	else if(sc == tc && tb>0) {
        		while(tb > 0 && j>=0) {
        			if(T.charAt(j)!='#') tb--;
        			else tb++;
        			j--;
        		}
        	}
        	else {
        		
        	if(sc == '#') {sb++;i--;continue;}
        	if(tc == '#') {tb++;j--;continue;}
        		
        	if(sb>0 && tb>0) {
        		sb--;
        		tb--;
        		i--;
        		j--;
        		continue;
        	}
        	else if(sb>0) {
        		sb--;
        		i--;
        	}
        	else if(tb>0) {
        		tb--;
        		j--;
        	}
        	else return false;	
        	}
        }
        
        return true;
    }
    
    
    public static void main(String[] args) {
		System.out.println(backspaceCompare("xywrrmp", "xywrrm#p"));
	}
    
}

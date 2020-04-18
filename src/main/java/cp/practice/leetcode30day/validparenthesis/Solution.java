package cp.practice.leetcode30day.validparenthesis;

import java.util.Stack;

class Solution {
    public static boolean checkValidString(String s) {
        Stack<Integer> stackofLeftParenthesispos = new Stack<>();
        Stack<Integer> jokerpos = new Stack<>();
        char leftparenthesis = '(';
        char joker = '*';     
        
        for (int i = 0; i < s.length(); i++) {
			
        	if (s.charAt(i) == leftparenthesis) stackofLeftParenthesispos.add(i);
        	else if(s.charAt(i) == joker)  jokerpos.add(i);
        	else {
        		if(stackofLeftParenthesispos.isEmpty() && jokerpos.isEmpty()) return false;
        		else {
        			if(!stackofLeftParenthesispos.isEmpty())
        				stackofLeftParenthesispos.pop();
        			else jokerpos.pop();
        		}
        	}
		}
        
        while(!stackofLeftParenthesispos.isEmpty()) {
        	
        	if(jokerpos.isEmpty()) return false;        	
        	if(stackofLeftParenthesispos.pop() > jokerpos.pop()) return false;
        	
        }
        
        return true;
     }

public static void main(String[] args) {
	System.out.println(checkValidString("(*))"));
}
    
}
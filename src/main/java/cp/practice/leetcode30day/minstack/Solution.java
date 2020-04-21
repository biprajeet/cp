package cp.practice.leetcode30day.minstack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

	List<Integer> stack;
    List<Integer> minstack; 
	
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minstack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(minstack.isEmpty()) minstack.add(x);
        else minstack.add(Math.min(minstack.get(minstack.size()-1),x));
    }
    
    public void pop() {
    	stack.remove(stack.size()-1);
    	minstack.remove(minstack.size()-1);
    }
    
    public int top() {
    	return stack.get(stack.size()-1);  
    }
    
    public int getMin() {
        return minstack.get(minstack.size()-1);
    }
}

class MinStack2 {

	List<Integer> stack;
    List<Value> minstack; 
	
    /** initialize your data structure here. */
    public MinStack2() {
        stack = new ArrayList<>();
        minstack = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(minstack.isEmpty()) minstack.add(new Value(x,0));
        else if(x < minstack.get(minstack.size()-1).element)
        		minstack.add(new Value(x,stack.size()-1));
    }
    
    public void pop() {
    	stack.remove(stack.size()-1);
    	if(stack.size()==minstack.get(minstack.size()-1).startpos)
    		minstack.remove(minstack.size()-1);
    }
    
    public int top() {
    	return stack.get(stack.size()-1);  
    }
    
    public int getMin() {
        return minstack.get(minstack.size()-1).element;
    }
}

class Value{
	
	int element;
	int startpos;
	public Value(int element, int startpos) {
		this.element = element;
		this.startpos = startpos;
	}
	
}

class Solution{
	
	public static void main(String[] args) {
		MinStack2 minStack = new MinStack2();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   
		minStack.pop();
		minStack.top();      
		minStack.getMin();   
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


package cp.practice.leetcode30day.uniquenumber;

import java.util.HashMap;

class FirstUnique {

	HashMap<Integer,Node> hash; 
	CustomList list;
    
    public FirstUnique(int[] nums) {
    	hash = new HashMap<>();
        list = new CustomList();
        for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
    }
    
    public int showFirstUnique() {
    	if(list.getSize() == 0)
    		return -1;
    	else 
    		return list.getFirst();
    }
    
    public void add(int value) {
        Node get = hash.get(value);
        if(get == null) {
        	Node temp = new Node(value);
        	list.addToLast(temp);
        	hash.put(value, temp);
        }
        else {
        	list.remove(get);
        }
    }
    
    class CustomList{
    	
    	Node head;
    	Node end;
    	int size=0;
    	
		void addToLast(Node n) {
			if (head == null)
				head = n;
			if (end == null)
				end = n;
			else {
				n.prev = end;
				n.next = null;
				end.next = n;
				end = n;
			}
			size++;
		}
    	
    	Integer getFirst() {
    		if(head == null) 
    			return null;
    		else 
    			return head.value;
    	}
    	
    	void remove(Node n) {
    		if(n.prev!=null && n.next!= null) {
    			n.prev.next = n.next;
    			n.next.prev = n.prev;
    		}
    		else if(n.prev == null && n.next == null) {
    			if(size == 1) {
    			 head = null;
    			 end = null;
    			}
    			else return;
    		}
    		else if(n.prev == null ) {
    			n.next.prev = null;
    			head = n.next;
    		}
    		else if(n.next == null ) {
    			end = n.prev;
    			n.prev.next = null;
    		}
    		n.next = null;
    		n.prev = null;
    		size--;
    	}

    	int getSize() {
    		return size;
    	}
    	
		@Override
		public String toString() {
			Node m = head;
			StringBuilder s = new StringBuilder();
			while(m != null) {
				s.append("data=>"+m.value+",");
				m = m.next;
			}
			return "CustomList ["+s.toString()+"]";
		}
    	
    }
    
    class Node {
    	Integer value;
    	Node prev;
    	Node next;
		public Node(Integer value) {
			this.value = value;
		}
    }
}

class Solution{
	public static void main(String[] args) {
		int a[] = {7,7,7,7,7,7};
		FirstUnique firstUnique = new FirstUnique(a);
		firstUnique.showFirstUnique(); // return -1
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
		firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
		firstUnique.showFirstUnique(); // return 17
	}
	
}


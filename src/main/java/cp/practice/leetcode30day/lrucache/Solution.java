package cp.practice.leetcode30day.lrucache;

import java.util.HashMap;

class LRUCache {
	
	HashMap<Integer,Node> hash; 
	CustomList list;
	int capacity;
	int counter;
	
    public LRUCache(int capacity) {
        hash = new HashMap<>();
        list = new CustomList();
        this.capacity = capacity;
        counter = 0;
    }
    
    public int get(int key) {
    	Node node = hash.get(key);
        if(node==null)
        	return -1;
        else {
        	list.remove(node);
        	list.addToLast(node);
        	return node.value;
        }
    }
    
    public void put(int key, int value) {
		if (get(key) == -1) {
			if (counter == capacity) {
				hash.remove(list.removeFromFirst());
				counter--;
			}

			Node node = new Node(key, value);
			list.addToLast(node);
			hash.put(key, node);
			counter++;
		}
    	else {
    		hash.get(key).value = value;
    	}
    }
    
    
    class CustomList{
    	
    	Node head;
    	Node end;
    	
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
		}
    	
    	Integer removeFromFirst() {
    		if(head == null) 
    			return null;
    		
    		int key = head.key;
    		if(head.next!=null)
    		 head.next.prev=null;
    		head = head.next;
    		return key;
    	}
    	
    	void remove(Node n) {
    		if(n.prev!=null && n.next!= null) {
    			n.prev.next = n.next;
    			n.next.prev = n.prev;
    		}
    		else if(n.prev == null && n.next == null) {
    			head = null;
    			end = null;
    		}
    		else if(n.prev == null ) {
    			n.next.prev = null;
    			head = n.next;
    		}
    		else if(n.next == null ) {
    			end = n.prev;
    			n.prev.next = null;
    		}
    	}

		@Override
		public String toString() {
			Node m = head;
			StringBuilder s = new StringBuilder();
			while(m != null) {
				s.append("key=>"+m.key+"data=>"+m.value+",");
				m = m.next;
			}
			return "CustomList ["+s.toString()+"]";
		}
    	
    }
    
    class Node {
    	Integer key;
    	Integer value;
    	Node prev;
    	Node next;
		public Node(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}
    }
}


class Solution{
	
	public static void main(String[] args) {
		
		/*
		 * Input: ["LRUCache","get","put","get","put","put","get","get"]
		 * 						[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]] Output:
		 * 						[null,-1,null,-1,null,null,2,-1] Expected: [null,-1,null,-1,null,null,2,6]
		 */
		LRUCache cache =  new LRUCache(1);
		
		cache.put(2, 1);
		
		
		System.out.println(cache.get(2));

		cache.put(3, 2);
	
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));

		
		
	}
	
}

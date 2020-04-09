package cp.practice.leetcode30day.middleoflinkedlist;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	
	/*
	 * public ListNode middleNode2(ListNode head) {
	 * 
	 * if (head == null) return head; else if (head.next == null) return head; else
	 * return middleNodeCount(head, 0); }
	 * 
	 * private ListNode middleNodeCount(ListNode head, int i) {
	 * 
	 * if(head!=null) { ListNode temp = middleNodeCount(head.next, ++i);
	 * 
	 * 
	 * } else { }; }
	 */
	 
	
	public ListNode middleNode(ListNode head) {
		Map<Integer, ListNode> map = new HashMap<>();
		int i = 0;
		do {
			map.put(++i, head);
			head = head.next;
		} while (head != null);

		return map.get((i / 2) + 1);
	}
}
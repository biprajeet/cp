package cp.practice.linkedlist;

public class Solution {

	public static Node addNumbers(Node n1, Node n2) {

		int d1, d2, d, carry = 0;
		Node n = new Node();
		Node r = n;

		while (n1 != null || n2 != null || carry > 0) {

			d1 = n1 == null ? 0 : n1.data;
			d2 = n2 == null ? 0 : n2.data;

			d = d1 + d2 + carry;
			carry = d / 10;
			d = d % 10;

			r.data = d;
			if ((n1 != null && n1.next != null) || (n2 != null && n2.next != null) || carry > 0) {
				r.next = new Node();
				r = r.next;
			}

			n1 = n1 == null ? n1 : n1.next;
			n2 = n2 == null ? n2 : n2.next;
		}

		return n;
	}

	
	public Boolean isLinkedListAPalindrome(Node n1) {
		
		
		return false;
	}
	
	public static void main(String[] args) {
		Node n1 = createlist(617);
		Node n2 = createlist(295);
		printlist(n1);
		printlist(n2);
		printlist(addNumbers(n1, n2));

	}

	private static void printlist(Node n1) {
		StringBuilder s = new StringBuilder();
		while (n1 != null) {
			s.append(n1.data);
			n1 = n1.next;
			if(n1!=null) s.append("->");
		}
		System.out.println(s.toString());
	}

	private static Node createlist(int num) {
		Node n = new Node();
		Node r = n;
		int d;
		while (num > 0) {
			d = num % 10;
			num /= 10;
			n.data = d;
			if (num > 0) {
				n.next = new Node();
				n = n.next;
			}
		}
		return r;
	}

}

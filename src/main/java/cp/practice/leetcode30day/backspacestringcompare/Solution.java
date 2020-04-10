package cp.practice.leetcode30day.backspacestringcompare;

import java.util.Stack;

class Solution {
	public static boolean backspaceCompare(String S, String T) {

		int sb = 0, tb = 0;
		char sc, tc;
		int i = S.length() - 1;
		int j = T.length() - 1;

		while (i >= 0 || j >= 0) {

			sc = i >= 0 ? S.charAt(i) : '?';
			tc = j >= 0 ? T.charAt(j) : '?';

			if (sc == tc && sb == 0 && tb == 0) {
				i--;
				j--;
				if (sc == '#') {
					sb++;
					tb++;
				}
			} else if (sc == tc && sb > 0) {
				while (sb > 0 && i >= 0) {
					if (S.charAt(i) != '#')
						sb--;
					else
						sb++;
					i--;
				}
			} else if (sc == tc && tb > 0) {
				while (tb > 0 && j >= 0) {
					if (T.charAt(j) != '#')
						tb--;
					else
						tb++;
					j--;
				}
			} else {

				if (sc == '#') {
					sb++;
					i--;
					continue;
				}
				if (tc == '#') {
					tb++;
					j--;
					continue;
				}

				if (sb > 0 && tb > 0) {
					sb--;
					tb--;
					i--;
					j--;
					continue;
				} else if (sb > 0) {
					sb--;
					i--;
				} else if (tb > 0) {
					tb--;
					j--;
				} else
					return false;
			}
		}

		return true;
	}

	// O(N) Space
	public static boolean backspaceCompare2(String S, String T) {
		Stack<Character> stackS = new Stack<>();
		Stack<Character> stackT = new Stack<>();
		for (int i = 0 ; i < S.length(); i++) {
			
			if(S.charAt(i)=='#' && stackS.size()!=0)stackS.pop();
			else if(S.charAt(i)!='#') stackS.push(S.charAt(i));
			
		}
		for (int i = 0 ; i < T.length(); i++) {
			
			if(T.charAt(i)=='#' && stackT.size()!=0)stackT.pop();
			else if(T.charAt(i)!='#') stackT.push(T.charAt(i));
			
		}
		
		if(stackS.size() != stackT.size()) return false;

		for (int i = 0; i < stackS.size(); i++) {
			if(stackS.pop() != stackT.pop()) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(backspaceCompare2("y#fo##f","y#f#o##f"));
	}

}

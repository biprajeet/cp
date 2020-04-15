package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class romanNumerals {

	public static int romanToInt(String s) {

		Map<Character,Integer> m = new HashMap<>();
		m.put('I',new Integer(1));
		m.put('V',new Integer(5));
		m.put('X',new Integer(10));
		m.put('L',new Integer(50));
		m.put('C',new Integer(100));
		m.put('D',new Integer(500));
		m.put('M',new Integer(1000));

		int res = 0,a,b= m.get(s.charAt(0));
		
		for (int i = 0; i < s.length()-1; i++) {
			
			a = m.get(s.charAt(i));
			b = m.get(s.charAt(i+1));
			if(a<b) res+=-a;
			else res+=a;
			
		}
		res+=b;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("D"));
	}
}

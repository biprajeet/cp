package cp.practice.leetcode30day.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfLists = new ArrayList<List<String>>();
        Integer pos;
        int c =0;
        Map<String, Integer> mapOfmappedStrings = new HashMap<String, Integer>();
        String temparr;
        for (int i = 0; i < strs.length; i++) {
        	temparr = map(strs[i]);
			pos = mapOfmappedStrings.get(temparr);
			if(pos == null) {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				listOfLists.add(temp);
				mapOfmappedStrings.put(temparr, c++);
			}
			else {
				listOfLists.get(pos).add(strs[i]);
			}
		}
        return listOfLists;
    }

	private static String map(String string) {
		int a[] = new int[26];
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			a[string.charAt(i)-'a']++;
		}
		for (int i = 0; i < a.length; i++) {
			s.append(a[i]+",");
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	
}
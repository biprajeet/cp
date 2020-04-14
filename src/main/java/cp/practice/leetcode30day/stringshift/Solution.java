package cp.practice.leetcode30day.stringshift;

class Solution {
	public String stringShift(String s, int[][] shift) {

		int amount;

		for (int i = 0; i < shift.length; i++) {

			StringBuilder str = new StringBuilder();
			StringBuilder temp = new StringBuilder();

			amount = shift[i][1] % s.length();

			// A left shift by 1 means remove the first character of s and append it to the
			// end.
			if (shift[i][0] == 0) {

				for (int j = 0; j < s.length(); j++) {
					if (j < amount)
						temp.append(s.charAt(j));
					else
						str.append(s.charAt(j));
				}
				str.append(temp);
				s = str.toString();
			}
			// a right shift by 1 means remove the last character of s and add it to the
			// beginning.
			else {

				for (int j = 0; j < s.length(); j++) {
					if (j < s.length() - amount)
						str.append(s.charAt(j));
					else
						temp.append(s.charAt(j));
				}
				temp.append(str);
				s = temp.toString();
			}
		}
		return s;
	}

	public String stringShift2(String s, int[][] shift) {

		int amount = 0;

		for (int i = 0; i < shift.length; i++) {

			amount += shift[i][0] == 0 ? shift[i][1] : -shift[i][1];

		}

		if (amount == 0)
			return s;

		StringBuilder str = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// A left shift by 1 means remove the first character of s and append it to the
		// end.
		if (amount > 0) {

			amount = amount % s.length();

			for (int j = 0; j < s.length(); j++) {
				if (j < amount)
					temp.append(s.charAt(j));
				else
					str.append(s.charAt(j));
			}
			str.append(temp);
			return str.toString();
		}
		// a right shift by 1 means remove the last character of s and add it to the
		// beginning.
		else {

			amount = -amount;

			amount = amount % s.length();

			for (int j = 0; j < s.length(); j++) {
				if (j < s.length() - amount)
					str.append(s.charAt(j));
				else
					temp.append(s.charAt(j));
			}
			temp.append(str);
			return temp.toString();
		}

	}
}
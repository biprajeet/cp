package cp.practice.leetcode30day.commonsubsequencestring;

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {

		int freq1[] = new int[26];
		int freq[] = new int[26];
		int i;

		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		for (i = 0; i < text1.length(); i++) {
			freq1[text1.charAt(i) - 'a'] = 1;
		}
		for (i = 0; i < text2.length(); i++) {
			if (freq1[text2.charAt(i) - 'a'] > 0) {
				freq[text2.charAt(i) - 'a'] = 1;
				s2.append(text2.charAt(i));
			}
		}

		for (i = 0; i < text1.length(); i++) {
			if (freq[text1.charAt(i) - 'a'] > 0)
				s1.append(text2.charAt(i));
		}

		return lcs(s1.toString(), s2.toString(), s1.length(), s2.length());
	}

	int lcs( String X, String Y, int m, int n ) 
	  { 
	    int L[][] = new int[m+1][n+1]; 
	  
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++) 
	    { 
	      for (int j=0; j<=n; j++) 
	      { 
	        if (i == 0 || j == 0) 
	            L[i][j] = 0; 
	        else if (X.charAt(i-1) == Y.charAt(j-1)) 
	            L[i][j] = L[i-1][j-1] + 1; 
	        else
	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
	      } 
	    } 
	  return L[m][n]; 
	  } 

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
	}
}
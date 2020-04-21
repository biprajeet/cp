package cp.practice.leetcode30day.minsumpath;

class Solution {
	public int minPathSum(int[][] grid) {
		return returnMinPath(0, 0, grid);
	}

	public int returnMinPath(int i, int j, int[][] grid) {

		if (i == grid.length - 1 && j == grid[0].length - 1)
			return grid[i][j];

		Integer right = j == grid[0].length - 1 ? Integer.MAX_VALUE : returnMinPath(i, j + 1, grid);
		Integer down = i == grid.length - 1 ? Integer.MAX_VALUE : returnMinPath(i + 1, j, grid);

		return grid[i][j] + Math.min(right, down);
	}

	public int minPathSum1(int[][] grid) {

		int m = grid.length-1; int n = grid[0].length-1;
        int i, j; 
        int tc[][]=new int[m+1][n+1]; 
  
        tc[0][0] = grid[0][0]; 
  
        for (i = 1; i <= m; i++) 
            tc[i][0] = tc[i-1][0] + grid[i][0]; 
  
        for (j = 1; j <= n; j++) 
            tc[0][j] = tc[0][j-1] + grid[0][j]; 
  
        for (i = 1; i <= m; i++) 
            for (j = 1; j <= n; j++) 
                tc[i][j] = Math.min(  
                               tc[i-1][j], 
                               tc[i][j-1]) + grid[i][j]; 
  
        return tc[m][n]; 
    } 
	
	public static void main(String[] args) {

		int[][] a = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		Solution sol = new Solution();
		System.out.println(sol.minPathSum1(a));
	}

}
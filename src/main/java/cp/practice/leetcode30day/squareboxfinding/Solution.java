package cp.practice.leetcode30day.squareboxfinding;

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        
        int res = 0;
        int i,j;
        
        for(i=0; i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                
                if(matrix[i][j]=='1'){
                    res = Math.max(res,findout(matrix, i, j));
                }
                
            }
        }

        return res;
    }
    
    public int findout(char matrix[][], int i, int j){
        
        int rows = matrix.length;
        int cols = matrix[0].length;
         
        int k = 1, l;
        
        while(i+k < rows && j+k< cols) {
            
            for(l=0;l<=k;l++){
                if(matrix[i+k][j+l] == '0') return k*k;
                if(matrix[i+l][j+k] == '0') return k*k;
            }
            k++;
        }
        
        return k*k;
    } 
    
    //USING DP
    
    public int maximalSquare2(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        markOnes(matrix, dp);
        
        return markOnes(matrix, dp);
    }
    
    private int markOnes(char[][] matrix, int[][] dp){
        int currentMax = 0;
        for(int j = 0; j < matrix[0].length; j++){
            for(int i = 0; i < matrix.length; i++){
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                } else {
                    int squareSize = 1;
                    if(j != 0 && i != 0){
                        squareSize += Math.min(dp[i - 1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    }
                    dp[i][j] = squareSize;
                    currentMax = Math.max(squareSize, currentMax);
                }
            }
        }
        return currentMax * currentMax;
    }
}
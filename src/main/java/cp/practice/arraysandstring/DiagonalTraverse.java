package cp.practice.arraysandstring;

public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] matrix) {
		
		
		
		
		
		
		return null;
	}

	public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null) {
           return null;
       }
       
       int M = matrix.length, N = (M > 0 ? matrix[0].length : 0), y = 0, x = 0, dy = -1, dx = 1;
       int[] diagonallyTraversed = new int[M * N];
       
       for (int i = 0; i < diagonallyTraversed.length; i++) {
           diagonallyTraversed[i] = matrix[y][x];
           y += dy;
           x += dx;
           
           if (y < 0) {
               if (x > N - 1) {
                   y += 2;
                   x = N - 1;
               }
               else {
                   y = 0;
               }
               
               dy = -dy;
               dx = -dx;
           }
           else if (y > M - 1) {
               y = M - 1;
               x += 2;
               
               dy = -dy;
               dx = -dx;
           }
           else {
               if (x < 0) {
                   x = 0;
               
                   dy = -dy;
                   dx = -dx;
               }
               else if (x > N - 1) {
                   y += 2;
                   x = N - 1;
               
                   dy = -dy;
                   dx = -dx;
               }
               else {
                   // do nothing
               }
           }
       }
       
       return diagonallyTraversed;
   }	
	
}

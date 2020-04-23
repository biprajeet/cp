package cp.practice.leetcode30day.numberofislands;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

	private int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0));
		int count=0;
		int visit = 0; 
		int total = (grid.length)*(grid[0].length);
		
		while(!q.isEmpty() && visit <=total) {
			
			node temp = q.remove();
			
			if(grid[temp.i][temp.j] == 'X') continue;
			
			if(grid[temp.i][temp.j] == '1') {
				
				count++;
				
				Queue<node> onequeue = new LinkedList<>();
				onequeue.add(temp);
				
				while(!onequeue.isEmpty()) {
				
					node temp2 = onequeue.remove();
						
					if(grid[temp2.i][temp2.j] == '1') {	
						
						grid[temp2.i][temp2.j] = 'X';
						visit++;
						
						addNode(temp2.i,temp2.j-1, grid, onequeue); 
						addNode(temp2.i,temp2.j+1, grid, onequeue);  
						addNode(temp2.i-1,temp2.j, grid, onequeue);  
						addNode(temp2.i+1,temp2.j, grid, onequeue); 
					}
					else if(grid[temp2.i][temp2.j] == '0') q.add(temp2);
				}
			}
			else if(grid[temp.i][temp.j] == '0') {
				
				grid[temp.i][temp.j] = 'X';
				visit++;
				
				addNode(temp.i,temp.j-1, grid, q);  
				addNode(temp.i,temp.j+1, grid, q);  
				addNode(temp.i-1,temp.j, grid, q);  
				addNode(temp.i+1,temp.j, grid, q); 
				
				addNode(temp.i-1,temp.j-1, grid, q);  
				addNode(temp.i+1,temp.j+1, grid, q);  
				addNode(temp.i-1,temp.j+1, grid, q);  
				addNode(temp.i+1,temp.j-1, grid, q); 
				
			}
		}
		
		return count;
	}
	
	
	public void addNode(int i, int j, char grid[][], Queue<node> queue) {
		
		if(i < 0 || j <0 || i > grid.length -1 || j > grid[0].length -1 || grid[i][j] == 'X') return;
		queue.add(new node(i,j)); 
		//System.out.println(queue.size());
	}
	
	class node {
		int i;
		int j;
		public node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		char a[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		//char a[][]  = {}; 
		Solution2 s = new Solution2();
		System.out.println(s.numIslands(a));
	
	}
}
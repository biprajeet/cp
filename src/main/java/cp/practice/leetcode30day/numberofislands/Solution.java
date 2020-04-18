package cp.practice.leetcode30day.numberofislands;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					++count;
					visit(i, j, grid, count);
				}
			}
		}
		return count;
	}

	private int visit(int i, int j, char[][] grid, int count) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(i,j));
		int visit = 0;
		
		while(!q.isEmpty()) {
			
			node temp = q.remove();
			visit++;
			if(grid[temp.i][temp.j] == '1') {
				if(temp.j!=0) q.add(new node(temp.i,temp.j-1)); 
				if(temp.j!=grid[0].length-1) q.add(new node(temp.i,temp.j+1)); 
				if(temp.i!=0) q.add(new node(temp.i-1,temp.j)); 
				if(temp.i!=grid.length-1) q.add(new node(temp.i+1,temp.j));
				grid[temp.i][temp.j] +=count;
			}
			else if(grid[temp.i][temp.j] == '0') {
				grid[temp.i][temp.j] = 'X';
			}
		}
		
		return visit;
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
		Solution s = new Solution();
		System.out.println(s.numIslands(a));
	
	}
	
	
	  public int numIslands2(char[][] grid) { 
	  
      int count = 0, visited=0, totallength  = grid.length*grid[0].length;
	  
	  int i=0,j=0;
	  
	  while(visited < totallength) {
	  
		  Queue<node> q = new LinkedList<>();
		  q.add(new node(i,j));
	  
		  while(!q.isEmpty()) {
				
				node temp = q.remove();
				visited++;
				
				if(grid[temp.i][temp.j] == '0') {
					if(temp.j!=0) q.add(new node(temp.i,temp.j-1)); 
					if(temp.j!=grid[0].length-1) q.add(new node(temp.i,temp.j+1)); 
					if(temp.i!=0) q.add(new node(temp.i-1,temp.j)); 
					if(temp.i!=grid.length-1) q.add(new node(temp.i+1,temp.j));
					grid[temp.i][temp.j] = 'X';
				}
				else if(grid[temp.i][temp.j] == '1') {
					visited+=visit(temp.i, temp.j, grid, ++count);
				}
			}
	  
	  }
	  
	  
	  return count; 
	  }
	  
	 
	
	
	public int numIslands3(char[][] grid) {
		int count = 0;
		char mark = '2';
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {

					char left = j == 0 ? '0' : grid[i][j - 1];
					char top = i == 0 ? '0' : grid[i - 1][j];

					if (left == '0' && top == '0') {
						grid[i][j] = mark++;
						count++;
					} else if (left == '0') {
						grid[i][j] = top;
					} else if (top == '0') {
						grid[i][j] = left;
					} else if (left == top) {
						grid[i][j] = top;
					} else {
						mark(i,j,grid,top,left);
						count--;
					}

				}
			}
		}
		return count;
	}
	 
	private void mark(int i, int j, char[][] grid, char mark, char findmark) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(i,j));
		
		while(!q.isEmpty()) {
			
			node temp = q.remove();
			
			if(grid[temp.i][temp.j] == findmark) {
				if(temp.j!=0) q.add(new node(temp.i,temp.j-1)); 
				if(temp.j!=grid[0].length-1) q.add(new node(temp.i,temp.j+1)); 
				if(temp.i!=0) q.add(new node(temp.i-1,temp.j)); 
				if(temp.i!=grid.length-1) q.add(new node(temp.i+1,temp.j));
				grid[temp.i][temp.j] = mark;
			}
		}
		
	}
}
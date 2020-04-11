package cp.practice.leetcode30day.diameterofabinarytree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


class Solution {
	public int diameterOfBinaryTree(TreeNode root) {
        int n = diameterOfBinaryTree(root, new Height());
        return n == 0? 0: n-1;
    }

	private int diameterOfBinaryTree(TreeNode root, Height height) {
		
		Height lh = new Height(); Height rh = new Height();
		if(root == null) {
			height.h=0;
			return 0;
		}
		
		int ld = diameterOfBinaryTree(root.left, lh);
		int rd = diameterOfBinaryTree(root.right, rh);
		
		height.h = Math.max(lh.h , rh.h) +1;
		
		return Math.max(lh.h+rh.h+1, Math.max(ld,rd));
	}
	class Height{
		int h;
	}
}
package cp.practice.leetcode30day.maxpath;

class Solution {

	public int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		findGreatestValue(root);
		return max;
	}

	  public int findGreatestValue(TreeNode root){
	        if (root == null)
				return Integer.MIN_VALUE;
			int left = findGreatestValue(root.left);
			int right = findGreatestValue(root.right);

			max = Math.max(max, root.val);
			max = Math.max(max, left);
			max = Math.max(max, right);
			
			int temp = Math.max(left, right);
			if(temp == Integer.MIN_VALUE) temp =0;
			
			if(left == Integer.MIN_VALUE) left =0;
			if(right == Integer.MIN_VALUE) right =0;
			max = Math.max(max, right + root.val);
			max = Math.max(max, left + root.val);
			max = Math.max(max, left + right + root.val);
			
			return Math.max(root.val, temp + root.val);  
	    }

	public static void main(String[] args) {

		Solution s = new Solution();
	    TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		
		//TreeNode root = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
		System.out.println(s.maxPathSum(root));
	}
}
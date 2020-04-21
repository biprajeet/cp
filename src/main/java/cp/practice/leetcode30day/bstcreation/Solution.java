package cp.practice.leetcode30day.bstcreation;

import java.util.Arrays;

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
     
    	Arrays.sort(preorder);
    	
    	return createNode(preorder, 0, preorder.length-1);
    }
    
    TreeNode createNode(int[] preorder, int low, int high){
    	
    	while(low>high) return null;
    	
    	int mid = (low+high)/2;
    	
    	TreeNode root = new TreeNode(preorder[mid]);
    	
    	System.out.println(preorder[mid]);
    	
    	root.left  = createNode(preorder, low, mid-1);
    	
    	root.right  = createNode(preorder, mid+1, high);
    	
    	return root;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
		
    	int b[] = {8,5,1,7,10,12};
    	Solution a = new Solution();
		a.bstFromPreorder(b);
	}
    
    public TreeNode bstFromPreorder1(int[] preorder) {
        
    	if(preorder == null) return null;
    	
    	TreeNode root = new TreeNode(preorder[0]);
    	
    	for (int i = 1; i < preorder.length; i++) {
			insertNodeInTree(root, preorder[i]);
		}
    	
    	return root;
    }

	private TreeNode insertNodeInTree(TreeNode node, int i) {
		
		if(node == null) return new TreeNode(i);
		
		if(i <node.val) node.left = insertNodeInTree(node.left, i);
		else node.right = insertNodeInTree(node.right, i);
		
		return node;
	}
}




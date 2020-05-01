package cp.practice.leetcode30day.binarytreesequence;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);    
    }
    
    public boolean isValidSequence(TreeNode root, int[] arr, int pointer) {
        if(root == null) return false;
        
        if(pointer < arr.length){
            
            if(arr[pointer] == root.val) {
                
                if(pointer == arr.length-1){ if(root.left == null && root.right == null) return true;
                                            else return false;                                          
                                         }
                else {
                    if(isValidSequence(root.left, arr, pointer+1) || isValidSequence(root.right, arr, pointer+1))
                        return true;
                    else return false;
                }
            }
            else return false;
        }
        else return false;
    }
    
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode() {}
    	      TreeNode(int val) { this.val = val; }
    	      TreeNode(int val, TreeNode left, TreeNode right) {
    	          this.val = val;
    	          this.left = left;
    	          this.right = right;
    	      }
    	  }
    	
}
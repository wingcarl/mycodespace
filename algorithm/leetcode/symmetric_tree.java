/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;
    	return isSymmetricTree(root.left,root.right);
    }
    private boolean isSymmetricTree(TreeNode left,TreeNode right){
    	if(left == null)
    		return right == null;
    	else if(right == null)
    		return false;
    	return left == right && isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
    }
}
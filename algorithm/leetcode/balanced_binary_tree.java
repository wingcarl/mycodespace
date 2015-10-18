/**
* Given a binary tree, determine if it is height-balanced.
* For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
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
     public boolean isBalanced(TreeNode root) {
    	if(root == null) return true;
    	if(Math.abs(calDeep(root.left)-calDeep(root.right)) > 1) return false;
    	if(!isBalanced(root.left) || !isBalanced(root.right)) return false;
    	return true;
    }
    private int calDeep(TreeNode root){
    	int deep = 0;
    	if(root == null) return 0;
    	deep = 1;
    	int ld = calDeep(root.left);
    	int rd = calDeep(root.right);
    	deep += Math.max(ld,rd);
    	return deep;
    }
}
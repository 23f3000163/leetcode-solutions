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

    public boolean isValid = true;
    public TreeNode prev = null;
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev == null) {
            prev = root;
        }
        else {
            if (root.val <= prev.val) {
                isValid = false;
            }
            prev = root;
        }

        inOrder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root); 
        return isValid;        
    }
}
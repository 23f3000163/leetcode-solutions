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

    public boolean isMirror(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null || rightRoot == null) {
            return leftRoot == rightRoot;
        }
        if (leftRoot.val == rightRoot.val &&
            isMirror(leftRoot.left, rightRoot.right) &&
            isMirror(leftRoot.right, rightRoot.left)) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        
        return isMirror(leftRoot, rightRoot);
    }
}
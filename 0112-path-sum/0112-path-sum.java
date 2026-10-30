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

    public boolean result = false; 

    public void pathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        //current node is leaf node
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result = true;
                return;
            }
        }
        //current root is non leaf node
        pathSum(root.left, sum, targetSum);
        pathSum(root.right, sum, targetSum);
        
        return;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        pathSum(root, sum, targetSum);
        return result;
    }
}
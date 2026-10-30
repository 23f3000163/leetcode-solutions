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

    public int result = 0; 

    public void fun(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        //current node is leaf node
        if (root.left == null && root.right == null) {
            result += sum;
            return;
        }
        //current root is non leaf node
        fun(root.left, sum);
        fun(root.right, sum);
        
        return;
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        fun(root, sum);
        return result;
    }
}
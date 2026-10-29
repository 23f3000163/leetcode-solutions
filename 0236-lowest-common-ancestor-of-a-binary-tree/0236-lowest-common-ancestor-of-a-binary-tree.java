/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode ans = null;

    public int solve(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }

        int left = solve(node.left, p, q);
        int right = solve(node.right, p, q);
        
        int self = 0;
        if (node == p || node == q) {
            self = 1;
        }

        int total = left + right + self;

        if (total == 2 && ans == null) {
            ans = node;
        }
        return total;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q);
        return ans;
    }
}
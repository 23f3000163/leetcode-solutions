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

    void fun(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            ans = root;
            return;
        } 
        if (root.val < p.val) {
            fun(root.right, p, q);
        }
        else if (root.val > q.val) {
            fun(root.left, p, q);
        }
        else {
            ans = root;
            return;
        }
    } 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            fun(root, p, q);
        }
        else {
            fun(root, q, p);
        }
        return ans;
    }
}
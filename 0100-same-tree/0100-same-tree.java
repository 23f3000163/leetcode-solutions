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

    static boolean sameOrNot( TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
    
        if (first.val != second.val) {
            return false;
        }
        if (!sameOrNot(first.left, second.left)) {
            return false;
        }
        if (!sameOrNot(first.right, second.right)) {
            return false;
        }
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameOrNot(p, q);
    }
}
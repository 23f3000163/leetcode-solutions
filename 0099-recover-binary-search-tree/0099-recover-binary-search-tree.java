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

    public TreeNode prev = null;
    public TreeNode galat1first = null;
    public TreeNode galat1second = null;
    public TreeNode galat2first = null;
    public TreeNode galat2second = null;
    public int galat = 0;
    
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
                if (galat == 0) {
                    galat1first = prev;
                    galat1second = root;
                    galat++;
                }
                else {
                    galat2first = prev;
                    galat2second = root;
                    galat++;
                }
            }
            prev = root; // Update every time
        }

        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (galat == 1) {
            int temp1 = galat1second.val;
            galat1second.val = galat1first.val;
            galat1first.val = temp1;
        }
        else {
            int temp2 = galat2second.val;
            galat2second.val = galat1first.val;
            galat1first.val = temp2;
        }
    }
}
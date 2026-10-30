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

    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    // Get next smallest element
    TreeNode getSmall() {
        if (asc.isEmpty()) {
            return null;
        }

        TreeNode small = asc.pop();
        TreeNode rightChild = small.right;

        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }
    // Get next largest element
    TreeNode getBig() {
        if (desc.isEmpty()) {
            return null;
        }

        TreeNode big = desc.pop();
        TreeNode leftChild = big.left;

        while (leftChild != null) {
            desc.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        // Initialize ascending iterator
        TreeNode curr = root;

        while (curr != null) {
            asc.push(curr);
            curr = curr.left;
        }
        // Initialize descending iterator
        curr = root;
        while (curr != null) {
            desc.push(curr);
            curr = curr.right;
        }
        TreeNode i = getSmall();
        TreeNode j = getBig();

        while (i != null && j != null && i != j) {
            int sum = i.val + j.val;

            if (sum == k) {
                return true;
            }
            if (sum < k) {
                i = getSmall();
            } else {
                j = getBig();
            }
        }
        return false;
    }
}

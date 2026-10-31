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

    public void fun(TreeNode root, int sum, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));        
            }
        }

        fun(root.left, sum, targetSum, path, result);
        fun(root.right, sum, targetSum, path, result);

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        fun(root, sum, targetSum, path, result);
        return result;
    }
}
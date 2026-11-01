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
    int idx = 0;

    public TreeNode build(int[] preorder, int low, int high, Map<Integer, Integer> map) {
        // Base condition
        if (low > high) {
            return null;
        }
        // Get root from preorder
        int value = preorder[idx++];
        TreeNode root = new TreeNode(value);

        // Find root position in inorder
        int mid = map.get(value);

        // Construct left subtree
        root.left = build(preorder, low, mid - 1, map);

        // Construct right subtree
        root.right = build(preorder, mid + 1, high, map);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder values and their indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = 0;

        return build(preorder, 0, inorder.length - 1, map);
    }
}
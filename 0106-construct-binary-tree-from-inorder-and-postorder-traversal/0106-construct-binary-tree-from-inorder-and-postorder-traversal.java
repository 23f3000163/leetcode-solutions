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
    int idx;

    public TreeNode build(int[] postorder, int low, int high, Map<Integer, Integer> map) {
        // Base condition
        if (low > high) {
            return null;
        }
        // Get root from postorder
        int value = postorder[idx--];
        TreeNode root = new TreeNode(value);
        
        // Find root position in inorder
        int mid = map.get(value);
        
        // Construct right subtree
        root.right = build(postorder, mid + 1, high, map);

        // Construct left subtree
        root.left = build(postorder, low, mid - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1, map);
    }
}
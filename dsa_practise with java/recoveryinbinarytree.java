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
    TreeNode f = null, s = null, p = null;
    public void recoverTree(TreeNode root) {
        in(root);
        int t = f.val;
        f.val = s.val;
        s.val = t;
    }

    void in(TreeNode n) {
        if (n == null) return;
        
        in(n.left);
        
        if (p != null && p.val > n.val) {
            if (f == null) f = p;
            s = n;
        }
        p = n;
        
        in(n.right);
    }
}

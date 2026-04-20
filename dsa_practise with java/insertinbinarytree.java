
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
           
            root.right = insertIntoBST(root.right, val);
        } else {
           
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}

//iterative


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode curr = root;
        while (true) {
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            }
        }
        return root;
    }
}

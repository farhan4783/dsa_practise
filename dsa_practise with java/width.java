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
    class Pair{
        TreeNode n;
        int i;
        Pair(TreeNode n, int i){
            this.n=n;
            this.i=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int size=q.size();
            int l=0, r=0;
            for(int k=0; k<size; k++){
                Pair p= q.poll();
                TreeNode n= p.n;
                int i= p.i;
                if(k==0) l= i;
                if(k==size-1) r= i;
                if(n.left!=null) q.add(new Pair(n.left, 2*i));
                if(n.right!=null) q.add(new Pair(n.right, 2*i+1));
            }
            max=Math.max(max, r-l+1);
        }
        return max;
    }
}

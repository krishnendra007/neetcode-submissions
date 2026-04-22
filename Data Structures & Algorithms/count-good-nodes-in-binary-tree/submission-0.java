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
    private void count(TreeNode root,int[]ans,int maxv){
        if(root==null) return;
        if(root.val>=maxv){
            ans[0]++;
            maxv=Math.max(maxv,root.val);
        }

        count(root.left,ans,maxv);
        count(root.right,ans,maxv);
    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int ans[]= new int[1];
        count(root,ans,root.val);
        return ans[0];
    }
}
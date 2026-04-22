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
    private boolean check(TreeNode a,TreeNode b){
        if(a==null&&b==null) return true;
        if(a==null||b==null) return false;

        if(a.val!=b.val) return false;

        return check(a.left,b.left)&&check(a.right,b.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null) return true;
         if(root==null||subRoot==null) return false;
        boolean a1= check(root,subRoot);
        boolean b1=isSubtree(root.left,subRoot);
        boolean c1=isSubtree(root.right,subRoot);

        return a1||b1||c1;
    }
}
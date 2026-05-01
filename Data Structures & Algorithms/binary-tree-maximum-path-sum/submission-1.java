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
    public int fun(TreeNode root, int [] arr){
        if(root==null) {
            return 0;
        }

           // int v1= fun(root.left,arr);  << ignore negative path
           // int v2=fun(root.right,arr);

           int v1=Math.max(0,fun(root.left,arr));
           int v2=Math.max(0,fun(root.right,arr));
   
            arr[0]=Math.max(arr[0],v1+v2+root.val);
            return root.val+Math.max(v1,v2);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int arr[]= {0};
        arr[0]=root.val;
        fun(root, arr);
        return arr[0];
    }
}
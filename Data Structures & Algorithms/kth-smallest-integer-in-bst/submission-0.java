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
    public int kthSmallest(TreeNode root, int k) {
        int [] arr = new int[2];
        Arrays.fill(arr,0);
         inorder(root,k,arr);
         return arr[1];
    }

    public void inorder(TreeNode root, int k, int [] arr){
        if(root==null){
            return;
        }

        inorder(root.left,k,arr);

        arr[0]++;
        if(arr[0]==k) {
            arr[1]=root.val;
            return;
        }
        inorder(root.right,k,arr);

    }
}
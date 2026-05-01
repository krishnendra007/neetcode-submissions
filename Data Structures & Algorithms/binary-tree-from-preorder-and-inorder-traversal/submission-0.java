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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root=build(0,preorder.length-1,preorder,0,inorder.length-1,inorder,mp);
        return root;
    }

    public TreeNode build(int preStart,int preEnd, int[] preorder,int inStart,int inEnd,int[] inorder, HashMap<Integer,Integer>mp){

        if(preStart>preEnd||inStart>inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inNode= mp.get(preorder[preStart]);
        int nodeLeft = inNode-inStart;

        root.left = build(preStart+1,preStart+nodeLeft,preorder,inStart,inNode-1,inorder,mp );
        root.right = build(preStart+nodeLeft+1,preEnd,preorder,inNode+1,inEnd,inorder,mp );

        return root;

    }
}
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

public class Codec {

    String s="";
    private void in(StringBuilder ans,TreeNode root){
        if(root==null){
            ans.append("# ");
            return;
        }
        ans.append(root.val);
        ans.append(" ");
        in(ans,root.left);
        in(ans,root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans=new StringBuilder();

        in(ans,root);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    int ind=0;
    public TreeNode deserialize(String s) {
        if(s.charAt(ind)=='#'){
            ind+=2;
            return null;
        }

        int val=0;
        while(s.charAt(ind)!=' '){
            val=val*10+(s.charAt(ind)-'0');
            ind++;
        }
        ind++;

        TreeNode root= new TreeNode(val);
        root.left=deserialize(s);
        root.right=deserialize(s);

        return root;
        
    }
}

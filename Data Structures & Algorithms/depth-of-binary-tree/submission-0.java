class Solution {
    private int height(TreeNode root, int[] ans){
        if(root==null) return 0;
        int l=height(root.left,ans);
        int r=height(root.right,ans);

        ans[0]=Math.max(ans[0],Math.max(l,r)+1);

        return Math.max(l,r)+1;
    }
    public int maxDepth(TreeNode root) {
        int ans[] = new int[1];

        height(root, ans);
        return ans[0];
    }
}
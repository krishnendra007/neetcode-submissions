class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row=mat.length;
        int col=mat[0].length;

        int i=0,j=col-1;

        while(i<row&&j>=0){
            if(mat[i][j]==target){
                return true;
            }
            else if(mat[i][j]<target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}
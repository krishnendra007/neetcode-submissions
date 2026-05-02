class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        List<List<String>> res= new ArrayList<>();

        dfs(0,board,res);
        return res;
    }

    public void dfs(int col,char[][] board,List<List<String>> res ){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
            if(validate(board,row,col)){
                board[row][col]='Q';
                dfs(col+1,board,res);
                board[row][col]='.';
            }

        }
    }

    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            ans.add(new String(board[i]));
        }

        return ans;
    }

    public boolean validate( char [][] board,int row, int col){

        int r=row,c=col;

        while(r>=0&&c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
             r--;
             c--;
        }

        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
             c--;
        }

        r=row;
        c=col;
        while(c>=0&&r<board.length){
            if(board[r][c]=='Q'){
                return false;
            }
             r++;
             c--;
        }

        return true;
    }
}
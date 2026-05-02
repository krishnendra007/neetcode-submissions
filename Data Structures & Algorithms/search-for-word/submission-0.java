class Solution {
    int dx[]= new int[]{1,0,-1,0};
    int dy[]= new int[]{0,-1,0,1};
    private boolean fun(int[][]vis,char[][]b,String w, int ind,int x, int y){
        int n=b.length;
        int m=b[0].length;

        vis[x][y]=1;
        if(ind==w.length()-1) return true;

        for(int i=0;i<4;i++){
            int X=x+dx[i];
            int Y=y+dy[i];
            if(X>=0&&X<n&&Y>=0&&Y<m&&vis[X][Y]==0&&w.charAt(ind+1)==b[X][Y]){
                if(fun(vis,b,w,ind+1,X,Y)) return true;
            }
        }
        vis[x][y]=0;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!=word.charAt(0)) continue;
                int[][] vis= new int[n][m];
                if (fun(vis,board,word,0,i,j)) return true;
            }
        }
        return false;
    }
}
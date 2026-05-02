class Solution {
    int []dx=new int[]{1,0,-1,0};
    int[]dy=new int[]{0,-1,0,1};
    private void bfs(char[][]b,  int[][]vis,int x, int y){
        vis[x][y]=1;

        for(int i=0;i<4;i++){
            int X=dx[i]+x;
            int Y=dy[i]+y;

            if(X>=0&&Y>=0&&X<b.length&&Y<b[0].length&&vis[X][Y]==0&&b[X][Y]=='O'){
                bfs(b,vis,X,Y);
            }
        }

    }
    public void solve(char[][] b) {
        int n=b.length;
        int m=b[0].length;
        
        int vis[][]= new int[n][m];

        for(int i=0;i<m;i++){
            if(b[0][i]=='O'&&vis[0][i]==0) bfs(b,vis,0,i);
            if(b[n-1][i]=='O'&&vis[n-1][i]==0) bfs(b,vis,n-1,i);
        }

        for(int i=0;i<n;i++){
            if(b[i][0]=='O'&&vis[i][0]==0) bfs(b,vis,i,0);
            if(b[i][m-1]=='O'&&vis[i][m-1]==0) bfs(b,vis,i,m-1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0) b[i][j]='X';
            }
        }
    }
}
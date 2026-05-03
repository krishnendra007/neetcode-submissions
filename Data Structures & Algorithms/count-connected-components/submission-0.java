class Solution {
    private void dfs(int[]vis,List<Integer>[]g,int ind){
        vis[ind]=1;

        for(int x: g[ind]){
            if(vis[x]==0) dfs(vis,g,x);
        }
    }
    public int countComponents(int n, int[][] e) {
        List<Integer>[]g= new ArrayList[n];

        for(int i=0;i<n;i++) g[i]= new ArrayList<>();

        for(int []arr: e){
            int u=arr[0];
            int v=arr[1];
            g[u].add(v);
            g[v].add(u);
        }

        int [] vis= new int[n];

        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++; 
                dfs(vis,g,i);
            }
        }
        return cnt;
    }
}

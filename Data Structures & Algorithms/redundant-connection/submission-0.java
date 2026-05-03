class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<Integer>[]g= new ArrayList[n+1];

        for(int i=0;i<=n;i++) g[i]= new ArrayList<>();
        int st=edges[0][0];

        for(int []arr: edges){
            int u=arr[0];
            int v=arr[1];
            int[]vis= new int[n+1];
           if(dfs(vis,g,u,v)) return arr;

            g[u].add(v);
            g[v].add(u);
        }
        return new int[]{};
        
    }
    private boolean dfs(int[]vis,List<Integer>[]g,int ind,int t){
        vis[ind]=1;

        for(int x: g[ind]){
            if(x==t) return true;
            if(vis[x]==0){
                if(dfs(vis,g,x,t)) return true;
            } 
        }
        return false;
    }
}
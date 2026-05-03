class Solution {
    public List<Integer> spiralOrder(int[][] ma) {
        List<Integer> ans= new ArrayList<>();

        int n=ma.length;
        int m=ma[0].length;

        int r=0,c=0;
        while(r<n&&c<m){

            for(int i=c;i<m;i++){
                ans.add(ma[r][i]);
            }
            r++;


            for(int i=r;i<n;i++){
                ans.add(ma[i][m-1]);
            }
            m--;

           if(r<n){
            for(int i=m-1;i>=c;i--){
                ans.add(ma[n-1][i]);
            }
            n--;
           }

           if(c<m){
                for(int i=n-1;i>=r;i--){
                    ans.add(ma[i][c]);
                }
                c++;
           }
        }
        return ans;
    }
}
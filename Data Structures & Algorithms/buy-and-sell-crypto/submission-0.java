class Solution {
    public int maxProfit(int[] p) {
        int maxa=0;
        int minv=Integer.MAX_VALUE;
        int i=0;
        while(i<p.length){
            minv=Math.min(minv,p[i]);
            maxa=Math.max(maxa,p[i]-minv);
            i++;
        }

        return maxa;
    }
}
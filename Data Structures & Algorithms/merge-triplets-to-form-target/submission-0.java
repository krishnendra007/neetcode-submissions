class Solution {
    public boolean mergeTriplets(int[][] tr, int[] ta) {
        int n=tr.length;

        int a=0,b=0,c=0;

        for(int i=0;i<n;i++){
            if(tr[i][0]<=ta[0]&&tr[i][1]<=ta[1]&&tr[i][2]<=ta[2]){
                a=Math.max(a,tr[i][0]);
                b=Math.max(b,tr[i][1]);
                c=Math.max(c,tr[i][2]);

                if(a==ta[0]&&b==ta[1]&&c==ta[2]) return true;
            }
        }
        return false;
    }
}
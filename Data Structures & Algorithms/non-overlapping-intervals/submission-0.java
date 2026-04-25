class Solution {
    public int eraseOverlapIntervals(int[][] inte) {
        Arrays.sort(inte,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        for(int []arr:inte) System.out.println(arr[0]+" "+arr[1]);
        int cnt=0;
        int n=inte.length;
        if(n==1) return 0;

        int st=0,end=1;
        while(end<n){
            if(inte[st][1]>inte[end][0]){
                cnt++;
                if(inte[st][1]>inte[end][1]) st=end;
                end++;
            }
            else{
                st=end;
                end++;
            }
        }

        return cnt;

    }
}
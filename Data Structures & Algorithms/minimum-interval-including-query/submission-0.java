class Solution {
    public int[] minInterval(int[][] inte, int[] q) {
        Arrays.sort(inte,(a,b)->a[0]-b[0]);

        int n=q.length;
        int arr[][]= new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=q[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] ans= new int[n];

        int ii=0;
        for(int i=0;i<n;i++){
            int val=arr[i][0];
            int ind=arr[i][1];

            while(ii<inte.length&&inte[ii][0]<=val){
                int l=inte[ii][0];
                int r=inte[ii][1];
                pq.add(new int[]{r-l+1,r});
                ii++;
            }

            while(!pq.isEmpty()&&pq.peek()[1]<val){
                pq.poll();
            }
            if(pq.isEmpty()) ans[ind]=-1;
            else ans[ind]=pq.peek()[0];
        }

        return ans;
    }
}

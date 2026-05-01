class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int[] arr: points){
            int val =arr[0]*arr[0]+arr[1]*arr[1];
            pq.offer(new int[]{val,arr[0],arr[1]});
            if(pq.size()>k) pq.poll();
        }

        int [][] ans= new int [k][2];

        for(int i=0;i<k;i++){
            int[] temp=pq.poll();
            ans[i][0]=temp[1];
            ans[i][1]=temp[2];
        }
        return ans;
    }
}
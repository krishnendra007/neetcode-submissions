class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x: nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int x: mp.keySet()){
            int val=mp.get(x);
            pq.offer(new int []{val,x});
        }

        int j=0;
        int []ans= new int [k];

        while(k-->0){
            ans[j++]=pq.poll()[1];
        }

        return ans;

        }
}
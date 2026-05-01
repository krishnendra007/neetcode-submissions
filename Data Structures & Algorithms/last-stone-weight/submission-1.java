class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int x: stones){
            pq.offer(x);
        }

        while(pq.size()>=2){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y) {
                pq.add(Math.abs(x-y));
            }
        }
        return pq.size()>0?pq.peek(): 0;
    }
}
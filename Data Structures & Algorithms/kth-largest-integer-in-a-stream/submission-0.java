class KthLargest {

    PriorityQueue<Integer> pq;
    int si;

    public KthLargest(int k, int[] nums) {
        si=k;
        pq = new PriorityQueue<>();

        for(int x: nums){
            if(pq.size()<k){
                pq.add(x);
            } else{
                if(pq.peek()<x){
                    pq.poll();
                    pq.add(x);
                }
            }
        }
    }
    
    public int add(int x) {
        if(pq.size()<si){
                pq.add(x);
            } else{
                if(pq.peek()<x){
                    pq.poll();
                    pq.add(x);
                }
            }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
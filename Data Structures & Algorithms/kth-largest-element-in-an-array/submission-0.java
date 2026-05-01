class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        for(int x: nums){
            if(h.size()<k){
                h.add(x);

            } else{
                if(h.peek()<x){
                    h.poll();
                    h.add(x);
                }
                
            }
            
        }
        
        return h.peek();
    }
}
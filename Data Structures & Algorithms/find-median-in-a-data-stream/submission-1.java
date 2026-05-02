class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max= new PriorityQueue<>((a,b)->b-a);
        min= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size()>max.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(min.size()==max.size()){
            return ((double)(max.peek()*1.0+min.peek()))/2;
        } else{
            return max.peek();
        }
    }
}
// max  5 3 
// min  2 7 

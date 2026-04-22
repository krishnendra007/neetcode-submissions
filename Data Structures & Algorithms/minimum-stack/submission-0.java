class MinStack {
    ArrayList<Integer> list;
    int minv;

    public MinStack() {
        list= new ArrayList<>();
        minv=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(list.size()>0){
            minv=Math.min(minv,val);
        } else{
            minv=val;
        }
        
        list.add(val);
        list.add(minv);
    }
    
    public void pop() {
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        if(list.size()>0){
            minv=list.get(list.size()-1);
        }
        
    }
    
    public int top() {
        return list.get(list.size()-2);
    }
    
    public int getMin() {
        return minv;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st= new HashSet<>();
        
        while(true){
            int num=0;
            while(n>0){
                int rem=n%10;
                n=n/10;
                num+=rem*rem;
            }
            if(num==1) return true;
            if(st.contains(num)) return false;
            st.add(num);
            n=num;
        }
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        int n=hand.length;
        if(n%g!=0) return false;

        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int x: hand){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

        
        while(!mp.isEmpty()){
            int val=mp.firstKey();

            for(int i=0;i<g;i++){
                int temp=val+i;
                if(!mp.containsKey(temp)){
                    return false;
                }
                int a=mp.get(temp);
                a--;
                if(a==0) mp.remove(temp);
                else mp.put(temp,a);
            }
        }
        return true;
    }
}
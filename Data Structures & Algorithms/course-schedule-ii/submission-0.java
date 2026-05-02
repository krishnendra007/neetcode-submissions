class Solution {
    public int[] findOrder(int num, int[][] pre) {
        List<Integer>[] g = new ArrayList[num];

        for(int i=0;i<num;i++) g[i]=new ArrayList<>();
        int[] in= new int[num];

        for(int []arr:pre){
            g[arr[0]].add(arr[1]);
            in[arr[1]]++;
        }

        Queue<Integer> q= new LinkedList<>();
        int ans[]= new int[num];

        for(int i=0;i<num;i++) if(in[i]==0) q.offer(i);

        int cnt=num-1;
        int total=0;
        while(!q.isEmpty()){
            int val=q.poll();
            ans[cnt]=val;
            cnt--;
            total++;
            for(int x: g[val]){
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }
        return total==num?ans: new int[]{};

    }
}

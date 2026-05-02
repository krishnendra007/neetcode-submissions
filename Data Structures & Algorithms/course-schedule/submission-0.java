class Solution {
    public boolean canFinish(int num, int[][] pre) {
       List<Integer>[] g = new ArrayList[num];

        for(int i=0;i<num;i++) g[i]=new ArrayList<>();
        int[] in= new int[num];

        for(int []arr:pre){
            g[arr[0]].add(arr[1]);
            in[arr[1]]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<num;i++) if(in[i]==0) q.offer(i);

        int cnt=0;
        while(!q.isEmpty()){
            int val=q.poll();
            cnt++;
            for(int x: g[val]){
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }

        return cnt==num;
    }
}
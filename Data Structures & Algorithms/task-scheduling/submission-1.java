class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : tasks)
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int x : mp.values())
            pq.offer(x);
        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < n + 1; i++) {

                if (!pq.isEmpty()) {
                    int v = pq.poll();
                    cnt++;
                    v--;
                    if (v > 0)
                        temp.add(v);
                }

            }

            time+= temp.size()>0 ?n+1: cnt;
            if(temp.size()>0){
                for(int x: temp) pq.add(x);
            }
        }
        return time;
    }
}
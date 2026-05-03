class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        // adjacency list: {neighbor, weight}
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();

        // build graph
        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            g[u].add(new int[]{v, w});
        }

        // min heap -> {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            // skip outdated entries
            if (d > dist[u]) continue;

            for (int[] nei : g[u]) {
                int v = nei[0];
                int w = nei[1];

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int)1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
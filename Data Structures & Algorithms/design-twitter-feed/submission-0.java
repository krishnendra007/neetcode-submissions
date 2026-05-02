
class Twitter {
    Map<Integer, PriorityQueue<int[]>> tw;
    Map<Integer, Set<Integer>> foll;
    int timestamp;

    public Twitter() {
        tw = new HashMap<>();
        foll = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tw.computeIfAbsent(userId, k -> new PriorityQueue<>((a, b) -> b[1] - a[1]))
                .offer(new int[] { tweetId, timestamp });
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int x : foll.getOrDefault(userId, new HashSet<>())) {
            PriorityQueue<int[]> temp1 = tw.get(x);
            if (temp1 == null)
                continue;

            PriorityQueue<int[]> copy = new PriorityQueue<>(temp1);

            int i = 0;
            while (!copy.isEmpty() && i < 10) {
                int[] arr = copy.poll();
                pq.offer(arr);
                i++;
                if (pq.size() > 10)
                    pq.poll();
            }
        }

        {
            PriorityQueue<int[]> temp1 = tw.getOrDefault(userId, new PriorityQueue<int[]>());
            if (temp1.size() > 0) {
                PriorityQueue<int[]> copy = new PriorityQueue<>(temp1);

                int i = 0;
                while (!copy.isEmpty() && i < 10) {
                    int[] arr = copy.poll();
                    pq.offer(arr);
                    i++;
                    if (pq.size() > 10)
                        pq.poll();
                }

            }
        }

        List<Integer> ans = new ArrayList();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        foll.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = foll.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
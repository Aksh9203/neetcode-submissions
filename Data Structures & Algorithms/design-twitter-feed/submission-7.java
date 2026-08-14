class Twitter {

    HashMap<Integer, HashSet<Integer>> followMp;
    HashMap<Integer, List<int[]>> tweetMp;
    int cnt;
    public Twitter() {
        followMp = new HashMap<>();
        tweetMp = new HashMap<>();
        cnt = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMp.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{cnt, tweetId});
        cnt++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        if(tweetMp.containsKey(userId)){
            pq.addAll(tweetMp.get(userId));
        }

        if(followMp.containsKey(userId)){
            for(int followers : followMp.get(userId)){
                if(followers == userId) continue;

                if(tweetMp.containsKey(followers)){
                    pq.addAll(tweetMp.get(followers));
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while(!pq.isEmpty() && feed.size() < 10){
            feed.add(pq.poll()[1]);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMp.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMp.get(followerId).remove(followeeId);
    }
}

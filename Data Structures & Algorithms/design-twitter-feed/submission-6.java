class Twitter {

    HashMap<Integer,HashSet<Integer>> followMp;
    HashMap<Integer, List<int[]>> tweetMp;
    int count;
    public Twitter() {
        followMp = new HashMap<>();
        tweetMp = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMp.containsKey(userId)){
            tweetMp.put(userId, new ArrayList<>());
        }
        tweetMp.get(userId).add(new int[]{count,tweetId});
        count++;
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
            int[] topFeed = pq.poll();
            feed.add(topFeed[1]);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMp.containsKey(followerId)){
            followMp.put(followerId, new HashSet<>());
        }
        followMp.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMp.get(followerId).remove(followeeId);
    }
}

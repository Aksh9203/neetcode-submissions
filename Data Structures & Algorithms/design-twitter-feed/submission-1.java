class Twitter {

    HashMap<Integer,HashSet<Integer>> followMp;
    HashMap<Integer,ArrayList<int[]>> tweetMp;
    int count = 0;

    public Twitter() {
        followMp = new HashMap<>();
        tweetMp = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMp.containsKey(userId)){
            tweetMp.put(userId, new ArrayList<>());
        }
        tweetMp.get(userId).add(new int[]{count,tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> ls = new ArrayList<>();
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

        ArrayList<Integer> feed = new ArrayList<>();

        while(feed.size() < 10 && pq.size() > 0){
            if(!pq.isEmpty()){
                int[] top = pq.poll();
                int tIds = top[1];
                feed.add(tIds);
            }
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

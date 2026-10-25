class Twitter {

    HashMap<Integer,HashSet<Integer>> followMp;
    HashMap<Integer,List<int[]>> tweetMp;
    int count;
    public Twitter() {
        followMp = new HashMap<>();
        tweetMp = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMp.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count,tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        if(tweetMp.containsKey(userId)){
            pq.addAll(tweetMp.get(userId));
        }

        if(followMp.containsKey(userId)){
            for(int follow : followMp.get(userId)){

                if(follow == userId) continue;

                pq.addAll(tweetMp.get(follow));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while(!pq.isEmpty() && feed.size() < 10){
            int[] recent = pq.poll();

            feed.add(recent[1]);
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

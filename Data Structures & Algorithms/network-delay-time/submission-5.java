class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int d = time[2];

            adj.get(u).add(new int[]{v,d});
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int v = top[0];
            int w = top[1];

            for(int[] neighbor : adj.get(v)){
                if(dis[v] != Integer.MAX_VALUE && dis[v] + neighbor[1] < dis[neighbor[0]]){
                    dis[neighbor[0]] = dis[v] + neighbor[1];
                    pq.add(new int[]{neighbor[0], dis[neighbor[0]]});
                }
                
            }
        }

        int minTime = 0;

        for(int i=1; i<=n; i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime,dis[i]);
            
        }

        return minTime;
    }
}

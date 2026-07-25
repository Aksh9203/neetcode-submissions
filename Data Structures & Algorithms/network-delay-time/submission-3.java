class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v,w});
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int v = top[0];
            int d = top[1];

            for(int[] j : adj.get(v)){
                if(dis[v] != Integer.MAX_VALUE && dis[j[0]] > dis[v] + j[1]){
                    dis[j[0]] = dis[v] + j[1];
                    pq.add(new int[]{j[0],dis[j[0]]});
                }
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,dis[i]);
        }

        return max;
    }
}

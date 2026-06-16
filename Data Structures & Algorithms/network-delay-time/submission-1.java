class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[]{v,t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int max = 0;

        dis[k] = 0;

        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int t = top[0];
            int u = top[1];


            for(int[] j : adj.get(u)){
                if(dis[j[0]] > dis[u] + j[1]){
                    dis[j[0]] = dis[u] + j[1];
                    pq.add(new int[]{dis[j[0]],j[0]});
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
        max = Math.max(max,dis[i]); 
        }
    return max;
    }
}

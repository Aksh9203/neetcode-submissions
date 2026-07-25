class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int d = flight[2];

            adj.get(u).add(new int[]{v,d});
        }

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

         Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int v = top[0];
            int d = top[1];
            int stop = top[2];

            if(stop == k+1) continue;

            for(int[] j : adj.get(v)){
                if(dis[j[0]] > dis[v] + j[1]){
                    if(dis[j[0]] < d + j[1]) continue;
                    dis[j[0]] = d + j[1];
                    pq.add(new int[]{j[0],dis[j[0]],stop+1});
                }
            }
        }

        if(dis[dst] == Integer.MAX_VALUE) return -1;

        return dis[dst];
    }
}

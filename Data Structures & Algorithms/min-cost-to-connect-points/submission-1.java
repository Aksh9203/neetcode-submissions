class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(new int[]{j,dis});
                adj.get(j).add(new int[]{i,dis});
            }
        }

        boolean[] vis = new boolean[n];
        int total = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();

            int v = top[0];
            int d = top[1];

            if(vis[v]) continue;

            total += d;
            vis[v] = true;

            for(int[] j : adj.get(v)){
                if(!vis[j[0]]){
                    pq.add(new int[]{j[0],j[1]});
                }
            }
        }
        return total;
    }
}

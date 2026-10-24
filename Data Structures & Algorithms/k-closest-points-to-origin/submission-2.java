class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point : points){
            pq.add(point);
            if(pq.size() > k){
                pq.poll();
            }  
        }

        List<int[]> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] top = pq.poll();

            ans.add(top);
        }

        return ans.toArray(int[][]::new);

    }
}

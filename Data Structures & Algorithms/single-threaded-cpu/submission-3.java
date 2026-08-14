class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] preserveIdx = new int[n][3];
        for(int i=0; i<n; i++){
            preserveIdx[i][0] = tasks[i][0];
            preserveIdx[i][1] = tasks[i][1];
            preserveIdx[i][2] = i;
        }

        Arrays.sort(preserveIdx, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int idx = 0;
        int[] ans = new int[n];
        int ansIdx = 0;
        int currTime = 0;

        while(idx < n || !pq.isEmpty()){
            if(pq.isEmpty() && currTime <= preserveIdx[idx][0]){
                currTime = preserveIdx[idx][0];
            }

            while(idx < n && preserveIdx[idx][0] <= currTime){
                pq.add(new int[]{preserveIdx[idx][1],preserveIdx[idx][2]});
                idx++;
            }

            int[] curTask = pq.poll();
            currTime += curTask[0];
            ans[ansIdx] = curTask[1];
            ansIdx++;
        }
        return ans;
    }
}
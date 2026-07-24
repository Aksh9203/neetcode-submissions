class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] preserveIdx = new int[n][3];
        for(int i = 0; i<n; i++){
            preserveIdx[i][0] = tasks[i][0];
            preserveIdx[i][1] = tasks[i][1];
            preserveIdx[i][2] = i;
        }

        Arrays.sort(preserveIdx, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] ans = new int[n];
        int idx = 0;
        int ansIdx = 0;
        int curTime = 0;

        while(idx < n || !pq.isEmpty()){
            if(pq.isEmpty() && curTime <= preserveIdx[idx][0]){
                curTime = preserveIdx[idx][0];
            }

            while(idx < n && preserveIdx[idx][0] <= curTime){
                pq.add(new int[]{preserveIdx[idx][1],preserveIdx[idx][2]});
                idx++;
            }

            int[] curTask = pq.poll();
            curTime += curTask[0];
            ans[ansIdx++] = curTask[1];

        }
        return ans;
    }
}
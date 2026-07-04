class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        int[] sorted = new int[n];

        for(int i=0; i<n; i++){
            sorted[i] = queries[i];
        }

        Arrays.sort(sorted);
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] result = new int[n];

        for(int s : sorted){
            int i = 0;

            while(i < intervals.length && intervals[i][0] <= s){
                int start = intervals[i][0];
                int end = intervals[i][1];
                pq.add(new int[]{end - start + 1,end});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < s){
                pq.poll();
            }

            mp.put(s, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        for(int i=0; i<n; i++){
            result[i] = mp.get(queries[i]);
        }

        return result;

    }
}

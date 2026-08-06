class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, ((a,b) -> a[1] - b[1]));

        List<int[]> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(result.isEmpty() || result.get(result.size() - 1)[1] <= intervals[i][0]){
                result.add(intervals[i]);
            }
        }

        return n - result.size();
    }
}

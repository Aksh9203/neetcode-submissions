class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();

        int idx = 0;

        //Left
        while(idx < n && intervals[idx][1] < newInterval[0]){
            result.add(intervals[idx]);
            idx++;
        }

        //Middle
        while(idx < n && newInterval[1] >= intervals[idx][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        result.add(new int[]{newInterval[0],newInterval[1]});

        //Right
        while(idx < n){
            result.add(intervals[idx]);
            idx++;
        }

        return result.toArray(new int[result.size() - 1][]);
    }
}

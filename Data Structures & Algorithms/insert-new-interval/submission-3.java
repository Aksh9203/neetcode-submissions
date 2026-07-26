class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        ArrayList<int[]> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(intervals[i][1] < newInterval[0]) ls.add(intervals[i]);
        }

        for(int i=0; i<n; i++){
            if(intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        ls.add(newInterval);

        for(int i=0; i<n; i++){
            if(intervals[i][0] > newInterval[1]) ls.add(intervals[i]);
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

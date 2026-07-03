class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        // ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        List<int[]> ls = new ArrayList<>();

        //Left side without overlapping with new Interval
        for(int i=0; i<n; i++){
            if(intervals[i][1] < newInterval[0]){
                ls.add(intervals[i]);
            }
        }

        //Middle part with overlapping
        for(int i=0; i<n; i++){
            if(intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }
        ls.add(newInterval);


        //Right side without overlapping with new Interval
        for(int i=0; i<n; i++){
            if(intervals[i][0] > newInterval[1]){
                ls.add(intervals[i]);
            }
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

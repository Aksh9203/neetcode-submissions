class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        int n = intervals.length;

        List<int[]> ls = new ArrayList<>();


        //Left
        while(idx < n && intervals[idx][1] < newInterval[0]){
            ls.add(intervals[idx]);
            idx++;
        }

        while(idx < n && newInterval[1] >= intervals[idx][0]){
            newInterval[0] = Math.min(intervals[idx][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1],newInterval[1]);
            idx++;
        }
        ls.add(new int[]{newInterval[0],newInterval[1]});

        while(idx < n){
            ls.add(intervals[idx]);
            idx++;
        }

        return  ls.toArray(new int[ls.size()][]);
    }
}

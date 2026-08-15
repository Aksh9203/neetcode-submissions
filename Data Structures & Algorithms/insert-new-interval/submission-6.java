class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> ls = new ArrayList<>();
        int i = 0;

        while(i < n && intervals[i][1] < newInterval[0]){
            ls.add(intervals[i]);
            i++;
        }

        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ls.add(new int[]{newInterval[0], newInterval[1]});

        while(i < n && newInterval[1] < intervals[i][0]){
            ls.add(intervals[i]);
            i++;
        }

        return ls.toArray(new int[ls.size() - 1][]);

    }
}

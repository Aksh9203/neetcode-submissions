class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        List<int[]> ls = new ArrayList<>();

        for(int[] interval : intervals){
            if(ls.isEmpty() || ls.get(ls.size() - 1)[1] <= interval[0]){
                ls.add(interval);
            } 
            // else {
            //     ls.get(ls.size() - 1)[1] = Math.max(interval[1],ls.get(ls.size() - 1)[1]);
            // }
        }

        return n - ls.size();
    }
}

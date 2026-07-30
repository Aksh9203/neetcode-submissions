class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        List<int[]> ls = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int i=0; i<n; i++){
            if(!ls.isEmpty() && ls.get(ls.size() - 1)[1] >= intervals[i][0]){
                ls.get(ls.size() - 1)[1] = Math.max(intervals[i][1],ls.get(ls.size() - 1)[1]);
            }
            else{
                ls.add(intervals[i]);
            }
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

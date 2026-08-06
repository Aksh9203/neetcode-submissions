class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(result.size() > 0 && result.get(result.size() - 1)[1] >= intervals[i][0]){
                result.get(result.size() - 1)[1] = Math.max(intervals[i][1],result.get(result.size() - 1)[1]);
            }
            else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size() - 1][]);
    }
}

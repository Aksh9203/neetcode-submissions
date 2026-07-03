class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(ls.isEmpty() || (ls.get(ls.size() - 1)[1] < intervals[i][0] || ls.get(ls.size() - 1)[0] > intervals[i][1])){
                ls.add(intervals[i]);
            }
            else{
                ls.get(ls.size() - 1)[0] = Math.min(ls.get(ls.size() - 1)[0],intervals[i][0]);
                ls.get(ls.size() - 1)[1] = Math.max(ls.get(ls.size() - 1)[1],intervals[i][1]);
            }
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

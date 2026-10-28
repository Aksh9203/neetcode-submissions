class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ls = new ArrayList<>();

        for(int[] interval : intervals){
            if(ls.isEmpty() || ls.get(ls.size() - 1)[1] < interval[0]){
                ls.add(interval);
            } else {
                ls.get(ls.size() - 1)[1] = Math.max(ls.get(ls.size() - 1)[1],interval[1]); 
            }
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

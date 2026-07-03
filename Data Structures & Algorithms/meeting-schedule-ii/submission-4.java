/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();

        if(n <= 1) return n;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        PriorityQueue<Integer> mQ = new PriorityQueue<>();
        mQ.add(intervals.get(0).end);

        for(int i=1; i<n; i++){
            Interval current = intervals.get(i);

            if(current.start >= mQ.peek()){
                mQ.poll();
            }
            mQ.add(current.end);
            
        }
        return mQ.size();
    }
}

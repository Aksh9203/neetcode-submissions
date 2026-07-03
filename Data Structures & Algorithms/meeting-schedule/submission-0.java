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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();

        if(n <= 1) return true;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        for(int i=1; i<n; i++){
            Interval previous = intervals.get(i-1);
            Interval current = intervals.get(i);

            if(current.start < previous.end) return false;
        }
        return true;
    }
}

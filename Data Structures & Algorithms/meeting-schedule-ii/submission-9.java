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

        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(!pq.isEmpty() && intervals.get(i).start >= pq.peek()){
                pq.poll();
            }
            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}

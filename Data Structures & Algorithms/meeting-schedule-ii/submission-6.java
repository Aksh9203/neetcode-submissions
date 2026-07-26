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

        Collections.sort(intervals,(a,b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);

        for(int i = 1; i<n; i++){
            if(intervals.get(i).start >= pq.peek()) pq.poll();
            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}

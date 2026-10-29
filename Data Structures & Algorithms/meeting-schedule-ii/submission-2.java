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
        intervals.sort((i1, i2) -> i1.start - i2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval i : intervals){
            if(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
            }

            pq.offer(i.end);
        }

        return pq.size();
    }
}

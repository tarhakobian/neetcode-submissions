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
        intervals.sort((a,b)->Integer.compare(a.start, b.start));
        
        if(intervals.size() == 0) return true;

        int prevEnd = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(interval.start < prevEnd) return false;

            prevEnd = interval.end;
        }

        return true;
    }
}

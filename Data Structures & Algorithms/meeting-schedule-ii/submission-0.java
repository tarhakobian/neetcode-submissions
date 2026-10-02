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
       if (intervals == null || intervals.size() == 0) return 0;

        // Sort by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        int rooms = 0;

        // Repeat until all intervals are assigned to a "room"
        while (!intervals.isEmpty()) {
            rooms++;

            List<Interval> nextLayer = new ArrayList<>();

            // Track the end of the last meeting placed in this room
            int prevEnd = intervals.get(0).end;

            for (int i = 1; i < intervals.size(); i++) {
                Interval curr = intervals.get(i);

                if (curr.start < prevEnd) {
                    // Overlaps → cannot fit into this room, push to nextLayer
                    nextLayer.add(curr);
                } else {
                    // No overlap → place it in this room, update prevEnd
                    prevEnd = curr.end;
                }
            }

            // Remaining intervals become input for the next "room"
            intervals = nextLayer;
        }

        return rooms;
    }
}

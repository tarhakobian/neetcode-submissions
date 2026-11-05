class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 1. Sort intervals in ascending order by their start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        // 2. Iterate starting from the second interval
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap detected: greedily remove the one that ends last
                // by keeping the minimum end time between the two.
                removals++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                // No overlap: update prevEnd to the current interval's end
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
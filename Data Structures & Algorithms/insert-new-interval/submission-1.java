class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        int target = newInterval[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < left; i++) {
            res.add(intervals[i]);
        }

        res.add(newInterval);

        for (int i = left; i < intervals.length; i++) {
            res.add(intervals[i]);
        }

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : res) {
            if (merged.isEmpty() ||
                merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
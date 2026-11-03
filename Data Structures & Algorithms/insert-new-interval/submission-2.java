class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int insertIdx = intervals.length;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0]) {
                insertIdx = i;
                break;
            }
        }

        List<int[]> intervalList = new ArrayList<>();

        for (int i = 0; i < insertIdx; i++) {
            intervalList.add(intervals[i]);
        }

        intervalList.add(newInterval);

        for (int i = insertIdx; i < intervals.length; i++) {
            intervalList.add(intervals[i]);
        }

        List<int[]> merged = new ArrayList<>();
        merged.add(intervalList.get(0));

        for (int i = 1; i < intervalList.size(); i++) {
            int[] curr = intervalList.get(i);
            int[] prev = merged.get(merged.size() - 1);

            if (curr[0] > prev[1]) {
                merged.add(curr);
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }

        return merged.toArray(int[][]::new);
    }
}
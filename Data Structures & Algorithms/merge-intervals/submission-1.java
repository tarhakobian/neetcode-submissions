class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            int[] lastInterval = res.get(res.size() - 1);

            if (lastInterval[1] < nextInterval[0]) {
                res.add(nextInterval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], nextInterval[1]);
            }
        }

        return res.toArray(int[][]::new);
    }
}
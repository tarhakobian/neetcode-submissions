class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        res.add(new ArrayList<>(subset));

        Set<Integer> seen = new HashSet<>();

        for (int j = i; j < nums.length; j++) {
            if (seen.contains(nums[j])) continue;

            seen.add(nums[j]);
            subset.add(nums[j]);

            dfs(j + 1);

            subset.remove(subset.size() - 1);
        }
    }
}
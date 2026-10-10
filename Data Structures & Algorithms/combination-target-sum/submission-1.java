class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();
    private int target;
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        dfs(0, 0);
        return res;
    }

    private void dfs(int i, int sum){
        if(sum > target || i == nums.length){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[i]);
        dfs(i, sum + nums[i]);
        combination.remove(combination.size() - 1);
        dfs(i + 1, sum);
    }
}

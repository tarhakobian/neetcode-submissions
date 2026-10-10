class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> permutation = new ArrayList<>();
    private int[] nums;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        this.nums = nums;
        this.visited = new boolean[nums.length];
        backtrack();
        return res;
    }

    private void backtrack() {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation)); // Add a copy of the list
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) continue;

            visited[j] = true;
            permutation.add(nums[j]);
            
            backtrack();
            
            // Backtrack (undo choices)
            permutation.remove(permutation.size() - 1);
            visited[j] = false;
        }
    }
}
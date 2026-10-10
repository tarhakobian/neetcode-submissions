class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();
    private int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return res;
    }

    private void dfs(int i) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (i > n) return;

        // Include i
        combination.add(i);
        dfs(i + 1);

        // Exclude i
        combination.remove(combination.size() - 1);
        dfs(i + 1);
    }
}
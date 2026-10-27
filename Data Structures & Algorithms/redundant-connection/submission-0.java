class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    // Helper to check if a path exists between source and destination (avoiding a specific edge to skip)
    private boolean canReach(int curr, int target, int skipU, int skipV, boolean[] visited) {
        if (curr == target) return true;
        visited[curr] = true;

        for (int neighbor : map.getOrDefault(curr, new ArrayList<>())) {
            // Skip the edge we are currently testing for removal
            if ((curr == skipU && neighbor == skipV) || (curr == skipV && neighbor == skipU)) {
                continue;
            }
            if (!visited[neighbor]) {
                if (canReach(neighbor, target, skipU, skipV, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            boolean[] visited = new boolean[edges.length + 1];
            if (canReach(u, v, u, v, visited)) {
                return edges[i];
            }
        }

        return new int[0];
    }
}
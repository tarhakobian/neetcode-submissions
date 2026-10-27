class Solution {
Map<Integer, List<Integer>> map = new HashMap<>();

    private boolean canTakeClass(int c, Set<Integer> visited, boolean[] classes) {
        if (classes[c]) return true;  // Already fully verified as safe!
        if (visited.contains(c)) return false; // Cycle detected
        
        visited.add(c);
        
        if (map.containsKey(c)) {
            for (Integer prereq : map.get(c)) {
                if (!canTakeClass(prereq, visited, classes)) return false;
            }
        }
        
        visited.remove(c); // Backtrack for other branches
        classes[c] = true; // Cache this course as safe
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            // FIX 1: Map prerequisite (prereq[1]) to the dependent course (prereq[0])
            map.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
        }
        
        boolean[] classes = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!classes[i]) {
                if (!canTakeClass(i, new HashSet<>(), classes)) return false;
            }
        }
        return true;
    }
}

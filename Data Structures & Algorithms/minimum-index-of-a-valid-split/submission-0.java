class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Count total occurrences of each element
        Map<Integer, Integer> totalOcc = new HashMap<>();
        for (int num : nums) {
            totalOcc.put(num, totalOcc.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the global dominant element
        int dominant = -1;
        int totalDominantCount = 0;
        for (Map.Entry<Integer, Integer> entry : totalOcc.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                totalDominantCount = entry.getValue();
                break;
            }
        }
        
        // Step 3: Iterate through possible split indices
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            
            int rightCount = totalDominantCount - leftCount;
            
            boolean leftValid = leftCount * 2 > (i + 1);
            boolean rightValid = rightCount * 2 > (n - 1 - i);
            
            if (leftValid && rightValid) {
                return i;
            }
        }
        
        return -1;
    }
}
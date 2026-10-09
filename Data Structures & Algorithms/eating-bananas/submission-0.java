class Solution {
    private boolean canEat(int k, int[] piles, int h) {
        long totalHours = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / k)
            totalHours += (pile + k - 1) / k; 
        }
        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int leftK = 1;
        int rightK = 0;
        
        // Find the maximum pile size for the upper bound
        for (int pile : piles) {
            rightK = Math.max(rightK, pile);
        }

        int minK = rightK;

        while (leftK <= rightK) {
            int midK = leftK + (rightK - leftK) / 2;

            if (canEat(midK, piles, h)) {
                minK = midK;
                rightK = midK - 1; // Try to find a smaller valid speed
            } else {
                leftK = midK + 1;  // Speed is too slow
            }
        }

        return minK;
    }
}
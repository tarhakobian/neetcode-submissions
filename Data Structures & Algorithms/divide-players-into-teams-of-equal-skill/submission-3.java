class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0, right = skill.length - 1;
        int expectedSum = skill[0] + skill[skill.length - 1];
        long totalChemistry = 0;
        while(left < right){
            int sum = skill[left] + skill[right];
            if(sum != expectedSum) return -1;
            totalChemistry += (long)skill[left] * skill[right];  
            left++;
            right--;         
        }
        return totalChemistry == 0 ? -1 : totalChemistry;
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIdx = m + n - 1,  n1Idx = m - 1, n2Idx = n - 1;

        while(n1Idx >= 0 && n2Idx >= 0){
            if(nums2[n2Idx] > nums1[n1Idx]){
                nums1[insertIdx] = nums2[n2Idx];
                n2Idx--;
            }else{
                nums1[insertIdx] = nums1[n1Idx];
                n1Idx--;
            }
            insertIdx--;
        }

        while(n1Idx >= 0){
            nums1[insertIdx] = nums1[n1Idx];
            n1Idx--;
            insertIdx--;
        }

        while(n2Idx >= 0){
            nums1[insertIdx] = nums2[n2Idx];
            n2Idx--;
            insertIdx--;
        }
    }
}
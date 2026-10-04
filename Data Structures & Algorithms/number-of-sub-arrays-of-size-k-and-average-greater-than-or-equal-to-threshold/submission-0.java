class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = left + k;
        int sum = 0;
        int res = 0;

        for(int i = 0; i < k; i++) sum += arr[i];
        if(sum / k >= threshold) res++;

        for(int i = k; i < arr.length; i++){
            sum += arr[i] - arr[i-k];
            if(sum / k >= threshold) res++;
        }

        return res;
    }
}
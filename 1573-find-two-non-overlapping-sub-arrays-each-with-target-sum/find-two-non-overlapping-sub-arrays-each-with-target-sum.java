class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        int left = 0;
        int currentSum = 0;
        int minTotalLength = Integer.MAX_VALUE / 2;

        for(int right = 0; right < n; right++){
            currentSum += arr[right];

            while(currentSum > target && left <= right){
                currentSum -= arr[left];
                left++;
            }
            dp[right + 1] = dp[right];

            if(currentSum == target){
                int currentLen = right - left + 1;

                if(dp[left] != Integer.MAX_VALUE / 2){
                    minTotalLength = Math.min(minTotalLength, dp[left] + currentLen);
                }
                dp[right + 1] = Math.min(dp[right + 1], currentLen);
            }
        }
        return minTotalLength >= Integer.MAX_VALUE / 2 ? -1 : minTotalLength;
    }
}
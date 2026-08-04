class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; 
        int maxAns = 0, zeroCount = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] == 0){
                zeroCount++;
            }
            if(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                    
                }
                left++;
               
            }

        }
        return nums.length-left;
    }
}
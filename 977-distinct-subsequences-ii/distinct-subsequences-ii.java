class Solution {
    public int distinctSubseqII(String s) {
       int MOD = 1000000007;
       int[] dp = new int[26];
       int total = 0;
       for(char ch : s.toCharArray()) {
        int index = ch - 'a';
        int newTotal = (2 * total + 1 - dp[index]) % MOD;

        if(newTotal < 0){
            newTotal += MOD;
        }
        dp[index] = (total + 1) % MOD;
        total = newTotal;
       }
       return (int) total;
    }
}
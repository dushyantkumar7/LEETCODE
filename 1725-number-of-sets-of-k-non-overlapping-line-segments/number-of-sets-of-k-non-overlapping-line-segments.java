class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        long N = n + k - 1;
        long R = 2L * k;
        if(R > N) return 0;
        long numerator = 1;
        long denominator = 1;

        for(int i = 1; i <= R; i++ ){
            numerator = (numerator * (N - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        long inverseDenominator = modPow(denominator, MOD - 2);
        return (int) ((numerator * inverseDenominator) % MOD);
    }
    private long modPow(long base, long exp){
        long result = 1;
        base %= MOD;
        while(exp > 0){
            if((exp & 1) == 1){
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
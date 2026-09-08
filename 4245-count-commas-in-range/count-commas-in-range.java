class Solution {
    public int countCommas(int n) {
       int count = 0;
       int start = 1000;

       while(start <= n) {
        count += n - start +1;
        start *= 1000;
       }
       return count;
    }
}
public class Solution {

    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If the number of 0s is even, Alice wins if both 1s and 2s exist.
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If the number of 0s is odd, Alice wins if the difference between 1s and 2s > 2.
        return Math.abs(count[1] - count[2]) > 2;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Expected Output -> true
        int[] stones1 = {2, 1, 0};
        System.out.println("Test 1: " + solver.stoneGameIX(stones1));

        // Test Case 2: Expected Output -> false
        int[] stones2 = {2};
        System.out.println("Test 2: " + solver.stoneGameIX(stones2));

        // Test Case 3: Expected Output -> false
        int[] stones3 = {5, 1, 2, 4, 3};
        System.out.println("Test 3: " + solver.stoneGameIX(stones3));
    }
}
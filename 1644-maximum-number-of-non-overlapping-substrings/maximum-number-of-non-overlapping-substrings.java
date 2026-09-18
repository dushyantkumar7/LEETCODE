class Solution {
    public List<String> maxNumOfSubstrings(String s) {
       int[] L = new int[26];
       int[] R = new int[26];
       Arrays.fill(L, -1);
       Arrays.fill(R, -1);

       int n = s.length();
       for(int i = 0; i < n; i++){
        int c = s.charAt(i) - 'a';
        if(L[c] == -1) L[c] = i;
        R[c] = i;
       }
       List<int[]> intervals = new ArrayList<>();
       for(int i = 0; i < 26; i++){
        if(L[i] != -1){
            int right = checkValid(s, i, L, R);
            if(right != -1){
                intervals.add(new int[]{L[i], right});
            }
        }
       }
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

       List<String> result = new ArrayList<>();
       int lastEnd = -1;

       for(int[] interval : intervals){
        if(interval[0] > lastEnd){
            result.add(s.substring(interval[0], interval[1] + 1));
            lastEnd = interval[1];
        }
       }
       return result;
    }
    private int checkValid(String s, int charIdx, int[] L, int[] R){
        int left = L[charIdx];
        int right = R[charIdx];

        for(int i = left; i <= right; i++){
            int c = s.charAt(i) - 'a';
            if(L[c] < left){
                return -1;
            }
            right = Math.max(right, R[c]);
        }
        return right;
    }
}
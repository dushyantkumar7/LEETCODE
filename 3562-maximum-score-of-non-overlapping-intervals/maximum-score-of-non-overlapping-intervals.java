class Solution {

    static class Interval {
        int l, r, w, id;
        public Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }


    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for(int i = 0; i < n; i++){
            List<Integer> in = intervals.get(i);
            arr[i] = new Interval(in.get(0), in.get(1), in.get(2), i);
        }
        Arrays.sort(arr, (a,b) ->{
           if (a.r != b.r) return Integer.compare(a.r, b.r);
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.id, b.id);
        });

        long[][] dpScore = new long[5][n + 1];
        int[][][] dpSeq = new int[5][n + 1][];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dpSeq[k][i] = new int[0];
            }
        }
        for (int i = 1; i <= n; i++) {
            int j = binarySearch(arr, arr[i - 1].l);

            for (int k = 1; k <= 4; k++) {
                long bestScore = -1;
                int[] bestSeq = null;

                long s1 = dpScore[k][i - 1];
                int[] seq1 = dpSeq[k][i - 1];
                bestScore = s1;
                bestSeq = seq1;

                long s2 = dpScore[k - 1][j] + arr[i - 1].w;
                int[] prevSeq = dpSeq[k - 1][j];
                int[] seq2 = new int[prevSeq.length + 1];
                System.arraycopy(prevSeq, 0, seq2, 0, prevSeq.length);
                seq2[seq2.length - 1] = arr[i - 1].id;
                Arrays.sort(seq2);


                if (isBetter(s2, seq2, bestScore, bestSeq)) {
                    bestScore = s2;
                    bestSeq = seq2;
                }

                    long s3 = dpScore[k - 1][i];
                int[] seq3 = dpSeq[k - 1][i];
                if (isBetter(s3, seq3, bestScore, bestSeq)) {
                    bestScore = s3;
                    bestSeq = seq3;
                }
                dpScore[k][i] = bestScore;
                dpSeq[k][i] = bestSeq;
                }
        }
        return dpSeq[4][n]; 
    }
    
    private int binarySearch(Interval[] arr, int targetL) {
        int left = 0, right = arr.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].r < targetL) {
                ans = mid + 1; 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean isBetter(long s1, int[] seq1, long s2, int[] seq2) {
        if (s1 > s2) return true;
        if (s2 > s1) return false;
        for (int i = 0; i < Math.min(seq1.length, seq2.length); i++) {
            if (seq1[i] < seq2[i]) return true;
            if (seq2[i] < seq1[i]) return false;
        }
        return seq1.length < seq2.length;
    }
}
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sx = 0, sy =0, litterCount = 0;

        int [][] litterId = new int[m][n];
        for(int[] row : litterId)Arrays.fill(row, -1);

        for(int i =0 ; i< m; i++){
            for(int j = 0; j < n; j++){
                char cell = classroom[i].charAt(j);

                if(cell == 'S'){
                    sx = i;
                    sy = j;
                } else if (cell == 'L'){
                    litterId[i][j] = litterCount++;
                }
            }
        }
        int fullMask = (1 << litterCount) - 1;
        if(fullMask == 0) return 0;

        int[][][] bestEnergy = new int[m][n][1<<litterCount];
        for(int i = 0; i < m; i++){
            for(int j =0 ; j<n; j++){
                Arrays.fill(bestEnergy[i][j],-1);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sx, sy, 0, energy,0});
        bestEnergy[sx][sy][0] = energy;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            int mask = curr[2], remaining = curr[3], steps = curr[4];

             if (mask == fullMask) return steps;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    classroom[nr].charAt(nc) == 'X' || remaining == 0) {
                    continue;
                }
                int nextEnergy = remaining - 1;
                int nextMask = mask;
                char nextCell = classroom[nr].charAt(nc);

                if (nextCell == 'L') {
                    nextMask |= 1 << litterId[nr][nc];
                }

                if (nextCell == 'R') {
                    nextEnergy = energy;
                }
if (nextEnergy <= bestEnergy[nr][nc][nextMask]) continue;

                bestEnergy[nr][nc][nextMask] = nextEnergy;
                queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
            }
        }

        return -1;
    }
}
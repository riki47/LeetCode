class Solution {
    public int[] findBall(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int ans[] = new int[nc];
        
        for (int ball = 0; ball < nc; ball++) {
            int row = 0;
            int col = ball;
            
            while (row < nr) {
                if (grid[row][col] == 1) {
                    if (col + 1 >= nc || grid[row][col + 1] == -1) {
                        col = -1;
                        break;
                    }
                    row++;
                    col++;
                } else {
                    if (col - 1 < 0 || grid[row][col - 1] == 1) {
                        col = -1;
                        break;
                    }
                    row++;
                    col--;
                }
            }
            ans[ball] = col;
        }
        return ans;
    }
}
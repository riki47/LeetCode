class Solution {
    private void tellPlace(int[][] grid, int row, int col, int ball, int[] ans) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        if (row >= nr) {
            ans[ball] = col;
            return;
        }
        
        if (grid[row][col] == 1) {
            if (col + 1 >= nc || grid[row][col + 1] == -1) {
                ans[ball] = -1;
                return;
            }
            tellPlace(grid, row + 1, col + 1, ball, ans);
        } else {
            if (col - 1 < 0 || grid[row][col - 1] == 1) {
                ans[ball] = -1;
                return;
            }
            tellPlace(grid, row + 1, col - 1, ball, ans);
        }
    }
    public int[] findBall(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int ans[] = new int[nc];
        
        for (int ball = 0; ball < nc; ball++) {
            int row = 0;
            int col = ball;
            
            tellPlace(grid,row,col,ball,ans);
        }
        return ans;
    }
}
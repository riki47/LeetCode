class Solution {
    public int minOperations(int[][] grid, int x) {
        int r = grid.length;
        int c = grid[0].length;
        int flat[] = new int[r*c];
        int n = 0;
        for(int i = 0;i<r;i++)
        {
            for(int j = 0;j<c;j++)
            {
                flat[n++] = grid[i][j];
            }
        }
        Arrays.sort(flat);

        //personally i would have subtracted all the elemenst from each other and if not %x == 0 then i would have printed false

        for(int i = 0;i<n;i++)
        {
            if((flat[i] - flat[0])%x != 0)
                return -1;
        }

        int median = n/2;
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            count += (Math.abs(flat[i]-flat[median]))/x;
        }
        return count;
    }
}
// class Solution {
//     public int deleteGreatestValue(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int temp = 0;
//         int fmax = 0;
//         for(int i = 0;i<n;i++)
//         {
//             for(int j = 0;j<m;j++)
//             {
//                 int max = 0;
//                 for(int k = 1;k<n;k++)
//                 {
//                     if(grid[j][k]>grid[j][max])
//                         max = k;
//                 }
//                 temp = Math.max(temp,grid[j][max]);
//                 grid[j][max] = -1;
//             }
//             fmax+=temp;
//             temp = 0;
//         }
//         return fmax;
//     }
// }

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length-1;
        int fmax = 0;
        int temp = 0;
        for(int i = 0;i<m;i++)
            Arrays.sort(grid[i]);
        for(int j = n;j>=0;j--)
        {
            temp = 0;
            for(int i = 0;i<m;i++)
            {
                if(temp<grid[i][j])
                    temp = grid[i][j];
            }
            fmax += temp;
        }
        return fmax;
    }
}
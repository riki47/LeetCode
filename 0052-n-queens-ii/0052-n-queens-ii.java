// class Solution {
//     public static int co = 0;
//     static boolean check(int mat[][],int row,int col)
//     {
//         int n = mat.length;
//         for(int r = row;r>=0;r--)
//         {
//             if(mat[r][col] == 1)
//                 return false;
//         }
//         for(int c = col;c>=0;c--)
//         {
//             if(mat[row][c] == 1)
//                 return false;
//         }
//         for(int c = col, r = row; c >= 0 && r >= 0; c--,r--) 
//         {
//             if(mat[r][c] == 1)
//                 return false;
//         }
//         for(int c = col, r = row; c >= 0 && r < n ; c--,r++) 
//         {
//             if(mat[r][c] == 1)
//                 return false;
//         }
//         return true;
//     }
//     static void solqueen(int mat[][],int c)
//     {
//         if(c == mat.length)
//         {
//             co++;
//             return;
//         }
//         if(c < mat.length)
//         {
//             for(int  r = 0; r<mat.length; r++)
//             {
//                 if(check(mat,r,c))
//                 {
//                     mat[r][c] = 1;
//                     solqueen(mat,c+1);
//                     mat[r][c] = 0;
//                 }
//             }
//         }
        
//     }
//     public int totalNQueens(int n) {
//         co = 0;
//         int mat[][] = new int[n][n];
//         solqueen(mat,0);
//         return co;
//     }
// }
class Solution {
    public static int co = 0;
    static boolean check(int mat[][],int row,int col)
    {
        int n = mat.length;
        for(int r = row;r>=0;r--)
        {
            if(mat[r][col] == 1)
                return false;
        }
        for(int c = col;c>=0;c--)
        {
            if(mat[row][c] == 1)
                return false;
        }
        for(int c = col, r = row; c >= 0 && r >= 0; c--,r--) 
        {
            if(mat[r][c] == 1)
                return false;
        }
        for(int c = col, r = row; c >= 0 && r < n ; c--,r++) 
        {
            if(mat[r][c] == 1)
                return false;
        }
        return true;
    }
    static void solqueen(int mat[][],int c,int n)
    {
        if(c == n)
        {
            co++;
            return;
        }
        if(c < n)
        {
            for(int  r = 0; r<n; r++)
            {
                if(check(mat,r,c))
                {
                    mat[r][c] = 1;
                    solqueen(mat,c+1,n);
                    mat[r][c] = 0;
                }
            }
        }
        
    }
    public int totalNQueens(int n) {
        co = 0;
        int mat[][] = new int[n][n];
        solqueen(mat,0,mat.length);
        return co;
    }
}
class Solution {
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
    static void solqueen(int mat[][],int c,List<List<String>> s1)
    {
        if(c == mat.length)
        {
            save(s1,mat);
            return;
        }
        if(c < mat.length)
        {
            for(int  r = 0; r<mat.length; r++)
            {
                if(check(mat,r,c))
                {
                    mat[r][c] = 1;
                    solqueen(mat,c+1,s1);
                    mat[r][c] = 0;
                }
            }
        }
        
    }
    public static void save(List<List<String>> s1, int mat[][])
    {
        
        int n = mat.length;
        List<String> a1 = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j] == 0)
                    sb.append(".");
                else
                    sb.append("Q");
            }
            a1.add(sb.toString());
        }
        s1.add(a1);
    }
    public List<List<String>> solveNQueens(int n) {
        int mat[][] = new int[n][n];
        List<List<String>> s1 = new ArrayList<>();
        solqueen(mat,0,s1);
        return s1;
    }
}
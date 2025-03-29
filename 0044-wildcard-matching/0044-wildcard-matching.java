class Solution {
    public boolean recur(String s1,String s2,int i,int j,int dp[][])
    {
        int n = s1.length();
        int m = s2.length();
        if(i == n)
        {
            for(int z = j;z<m;z++)
            {
                if(s2.charAt(z) != '*') return false;
            }
            return true;
        }
        if(j>=m) return i>=n;
        if(dp[i][j] != -1)return (dp[i][j] == 1);
        
        if(i == n-1 && j == m-1 && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '*' || s2.charAt(j) == '?'))
            return true;

        if(s2.charAt(j) == '?' || s2.charAt(j) == s1.charAt(i))
        {
            dp[i][j] = recur(s1, s2, i+1, j+1,dp) ? 1 : 0;
            return dp[i][j] == 1;
        }
        if(s2.charAt(j) == '*')
        {
            dp[i][j] = (((recur(s1,s2,i+1,j,dp) || recur(s1,s2,i,j+1,dp)) == true)?1:0);
            return (dp[i][j] == 1);
        }
        else 
        {
            dp[i][j] = 0;
            return (dp[i][j] == 1);
        }
    }
    public boolean isMatch(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        int dp[][] = new int[n][m];
        for(int i[] : dp)
            Arrays.fill(i,-1);
        return recur(str,pat,0,0,dp);
    }
}

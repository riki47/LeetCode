class Solution {
    public boolean f(int stones[], int i, int k,int n,int dp[][])
    {
        if(i >= n-1)return true;
        if(dp[i][k] != -1) return (dp[i][k] == 1);

        boolean ans = false;
        for(int j = k-1;j<=k+1;j++)
        {
            if(j<=0) continue;
            for(int l = i+1;l<n;l++)
            {
                if(stones[l] > stones[i] + j)
                    break;
                if(stones[l] == stones[i] + j)
                    ans = f(stones, l, j, n,dp);
                if(ans == true)
                {
                    dp[i][k] = 1;
                    return true;
                }
            }
        }
        dp[i][k] = (ans)?1:0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int dp[][] = new int[n][n];
        for(int i[] : dp)
            Arrays.fill(i,-1);

        if(stones[1] == stones[0] + 1)
            return f(stones, 1, 1, n, dp);
        else
            return false;
    }
}
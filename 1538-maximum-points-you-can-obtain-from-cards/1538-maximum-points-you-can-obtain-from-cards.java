class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int i = 0, j = 0;
        int max = 0, sum = 0;
        int start = n-k;
        while(j < 2*k)
        {
            sum += cardScore[(start + j)%n];
            if(j-i+1 > k)
            {
              sum -= cardScore[(start + i)%n];
              i++;
            }
            j++;
            max = Math.max(sum,max);
        }
        return max;
    }
}
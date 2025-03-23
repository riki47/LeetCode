class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        while(j < 2*k)
        {
            sum += cardScore[(n-k+j)%n];
            if(j-i+1 > k)
            {
              sum -= cardScore[(n-k+i)%n];
              i++;
            }
            j++;
            max = Math.max(sum,max);
        }
      return max;
    }
}
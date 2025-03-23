class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int i = n-k;
        int j = n-k;
        int max = 0;
        int sum = 0;
        while(j < n+k)
        {
            sum += cardScore[j%n];
            if(j-i+1 > k)
            {
              sum -= cardScore[i%n];
              i++;
            }
            j++;
            max = Math.max(sum,max);
        }
      return max;
    }
}
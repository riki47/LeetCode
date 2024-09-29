class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        int max = 0;
        int emptys = 0;
        for(int i= citations.length-1; i>=0; i--)
        {
            count++;
            if(citations[i]<=count)
            {
                max = Math.max(max,citations[i]);
            }
            else if(citations[i]>=count)
                emptys++;
        }
        max = Math.max(emptys,max);
        return max;
    }
}
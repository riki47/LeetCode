class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i :nums)
        {
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int gdc = 1;
        for(int i = 2;i<=min;i++)
        {
            if(min%i == 0 && max%i == 0)
                gdc = i;
        }
        return gdc;
    }
}
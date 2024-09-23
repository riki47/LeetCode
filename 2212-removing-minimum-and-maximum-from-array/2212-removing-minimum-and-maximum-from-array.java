class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;
        int len = nums.length;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[min]>nums[i])
                min = i;
            if(nums[max]<nums[i])
                max = i;
        }
        int b = Math.min(min,max)+1 + Math.abs(max-min);
        int e = Math.min(len-min,len-max) + Math.abs(min-max);;
        int m1 = (min+1) + (len-max);
        int m2 = (len-min) + (max+1);
        return Math.min(b,Math.min(e,Math.min(m1,m2)));
    }
}
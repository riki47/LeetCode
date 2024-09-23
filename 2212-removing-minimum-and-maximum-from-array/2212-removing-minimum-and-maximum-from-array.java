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
        int s = Math.min(min,max);
        int bi = Math.max(min,max);
        
        int b = 1 + bi;
        int e = len - s;
        int m1 = s+1 + len- bi;
        return Math.min(b,Math.min(e,m1));
    }
}
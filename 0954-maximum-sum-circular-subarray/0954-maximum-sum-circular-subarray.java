class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxsum = nums[0];
        int masum = nums[0];
        int minsum = nums[0];
        int misum = nums[0];
        int n = nums.length;
        int total = nums[0];

        for(int i = 1;i<n;i++) 
        {
            masum = Math.max(masum+nums[i],nums[i]);
            maxsum = Math.max(masum,maxsum);
            misum = Math.min(misum+nums[i],nums[i]);
            minsum = Math.min(misum,minsum);
            total += nums[i];
        }
        if(maxsum < 0)
            return maxsum;
        return Math.max(maxsum,total-minsum);
    }
}
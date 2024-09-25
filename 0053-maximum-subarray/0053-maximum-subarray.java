class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int sum=nums[0];
        for (int i = 1; i < nums.length; i++)     
        {
            sum = Math.max(sum+nums[i],nums[i]);
            maxsum = Math.max(sum,maxsum);
        }
        return maxsum;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1;
        int max = 1;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]>res)
                res = nums[i];
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {    
                max = 1;
                min = 1;
                continue;
            }
            int tempmax = max*nums[i];
            max = Math.max(tempmax,Math.max(min*nums[i],nums[i]));
            min = Math.min(tempmax,Math.min(min*nums[i],nums[i]));
            
            res = Math.max(res,max);
        }
        return res;
    }
}
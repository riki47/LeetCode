class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0,max = 0;
        int len = nums.length;
        for(int i = 0; i<len; i++)
        {
            int n = nums[i];
            if(nums[min]>n)
                min = i;
            if(nums[max]<n)
                max = i;
        }
        int s = Math.min(min,max);
        int bi = Math.max(min,max);
        
        int b = 1 + bi;
        int e = Math.min(b,len - s);
        int m1 = s+1 + len- bi;
        return Math.min(m1,e);
    }
}
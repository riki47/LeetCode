class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int i = 0;
        int j = i;
        int zs = 0;
        int max = 0;
        while(j<nums.length)
        {
            if(nums[j] == 0)
                zs++;
            if(zs>k)
            {
                if(max<j-i)
                    max = j-i;
                zs = 1;
                while(nums[i] != 0)
                    i++;
                if(nums[i] == 0)
                    i++;
            }
            j++;
        }
        if(max<j-i)
            max = j-i;
        return max-1;
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int minval = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
            if(i>0 && nums[i] == nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j<k)
            {
                
                int sum = nums[i] + nums[j] + nums[k];
                if(min>Math.abs(sum-target))
                {
                    min = Math.abs(sum-target);
                    minval = sum;
                }
                if(sum>target)
                    k--;
                else if(sum<target)
                {
                    j++;
                    while(j<k && nums[j] == nums[j-1])j++;
                }
                else
                    return sum;
            }
        }     
        return minval;   
    }
}
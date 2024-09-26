class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int minval = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
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
                    j++;
                else
                    return sum;
            }
        }     
        return minval;   
    }
}
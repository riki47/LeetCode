class Solution {
    int ans = 0;
    void binsearch(int nums[],int target,int start,int end)
    {
        int mid = (start + end)/2;
        if(start<=end)
        {
            if(target>nums[mid])
            {
                binsearch(nums, target, mid+1, end);
            }
            if(target<=nums[mid])
            {
                ans = mid;
                binsearch(nums, target, start, mid-1);
            }
        }
    }
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1])
            return nums.length;
        else if(target<=nums[0])
            return 0;
        binsearch(nums, target, 0, nums.length-1);
        return ans;
    }
}
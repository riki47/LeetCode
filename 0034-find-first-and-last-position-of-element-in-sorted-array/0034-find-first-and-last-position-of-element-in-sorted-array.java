class Solution {
    int first = -1;
    int second = -1;
    void binary(int[] nums, int target, int start , int end)
    {
        if(start<=end)
        {
            int mid = ((end+start)/2);
            if(nums[mid]>target)
            {
                binary(nums,target,start ,mid-1);
            }   
            else if(nums[mid]<=target)
            {
                first = mid;
                binary(nums,target,mid+1 ,end);
            }
        }
    }
    void binaryc(int[] nums, int target, int start , int end)
    {
        if(start<=end)
        {
            int mid = ((end+start)/2);
            if(nums[mid]>=target)
            {
                second = mid;
                binaryc(nums,target,start ,mid-1);
            }   
            else if(nums[mid]<target)
            {
                binaryc(nums,target,mid+1 ,end);
            }
        }
    }
    public int[] searchRange(int[] nums, int target) {
        binary(nums,target,0,nums.length-1);
        if(first == -1 || nums[first] != target)
            return new int[]{-1,-1};
        
        binaryc(nums,target,0,nums.length-1);
        return new int[]{second,first};
    }
}
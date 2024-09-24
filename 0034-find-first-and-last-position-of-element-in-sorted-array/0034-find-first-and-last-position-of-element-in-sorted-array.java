class Solution {
    static int binary(int[] nums, int target, int start , int end)
    {
        if(start<=end)
        {
            int mid = ((end+start)/2);
            if(nums[mid]>target)
            {
                return binary(nums,target,start ,mid-1);
            }   
            else if(nums[mid]<target)
            {
                return binary(nums,target,mid+1 ,end);
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int pos = binary(nums,target,0,nums.length-1);
        if(pos == -1)
            return new int[]{-1,-1};
            
        int two[] = new int[2];
        int i = pos-1;
        int j = pos+1;
        
        while( i>=0 && nums[i] == nums[pos])
        {
            i--;
        }
        while(j<nums.length && nums[j] == nums[pos])
        {
            j++;
        }
        two[0] = ++i;
        two[1] = --j;
        return two;
    }
}
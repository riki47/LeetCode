class Solution {
    public boolean canJump(int[] nums) {
        int max= 0;
        int i = 0;
        while(i<=max)
        {
            max = Math.max(nums[i]+i,max);
            if(max >= nums.length-1)return true;
            i++;
        }
        return false;
    }
}

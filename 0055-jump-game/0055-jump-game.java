class Solution {
    public boolean canJump(int[] nums) {
        int max= 0;
        int i = 0;
        int n = nums.length-2;
        while(i<=max)
        {
            max = Math.max(nums[i]+i++,max);
            if(max > n)return true;
        }
        return false;
    }
}

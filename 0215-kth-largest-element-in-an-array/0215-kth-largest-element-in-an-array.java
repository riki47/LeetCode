class Solution {
    int prev = Integer.MAX_VALUE;
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = nums.length-1;
        int count = 1;
        while(count<k)
        {
            idx--;
            count++;
        }
        return nums[idx];
    }
}
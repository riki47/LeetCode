class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = nums.length-1;
        return nums[idx-k+1];
    }
}
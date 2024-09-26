// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);return nums[nums.length-k];
//     }
// }
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue <Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
        {
            q1.add(i);
        }
        while(k>1)
        {
            q1.poll();
            k--;
        }
        return q1.peek();
    }
}
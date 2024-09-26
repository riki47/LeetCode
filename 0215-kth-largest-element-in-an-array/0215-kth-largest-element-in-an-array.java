// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);return nums[nums.length-k];
//     }
// }
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> q1 = new PriorityQueue<>();
        for(int i:nums)
        {
            q1.offer(i);
            while(q1.size()>k)
            {
                q1.poll();
            }

        }
        return q1.poll();
    }
}
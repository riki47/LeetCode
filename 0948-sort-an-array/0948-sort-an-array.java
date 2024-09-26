class Solution {
    public int[] sortArray(int[] nums) {
        Queue<Integer> q1 = new PriorityQueue<>();
        for(int i : nums)
        {
            q1.offer(i);
        }
        int newn[] = new int[nums.length];
        for(int i = 0 ; i<nums.length; i++)
        {
            newn[i] = q1.poll();
        }
        return newn;
    }
}
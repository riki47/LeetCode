class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int twos = 0;
        for(int i : nums)
        {
            one ^= i & (~twos);
            twos ^= i & (~one);
        }
        return one;
    }
}
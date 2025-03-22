class Solution {
    public int[] singleNumber(int[] nums) {
        long xor1 = 0;
        for(int i : nums)
        {
            xor1 ^= i;
        }
        int ith = (int)(xor1 & (xor1-1)) ^ (int)xor1;
        
        int xor2 = 0;xor1 = 0;
        for(int i : nums)
        {
            if((i & ith) != 0)
                xor1 ^= i;
            else
                xor2 ^= i;
        }
        int ans[] = new int[]{(int)xor1,xor2};
        Arrays.sort(ans);
        return ans;
    }
}
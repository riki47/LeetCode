class Solution {
    HashSet<List<Integer>> l1 ;
    void comb(int nums[],ArrayList<Integer> a1)
    {
        if(nums.length <= 0)
        {
            l1.add(new ArrayList(a1));
            return;
        }
        for(int idx = 0; idx<nums.length; idx++)
        {   
            a1.add(nums[idx]);
            int[] firstPart = Arrays.copyOfRange(nums, 0, idx);     
            int[] secondPart = Arrays.copyOfRange(nums, idx + 1, nums.length); 
            int[] result = new int[firstPart.length + secondPart.length];
            System.arraycopy(firstPart, 0, result, 0, firstPart.length);
            System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);
            comb(result,a1);
            a1.removeLast();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        l1  = new HashSet<>();
        comb(nums, new ArrayList<>());
        return new ArrayList<>(l1);
    }
}
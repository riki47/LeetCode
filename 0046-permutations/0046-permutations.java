class Solution {
    static void comb(int nums[],ArrayList<Integer> a1,List<List<Integer>> l1)
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
            comb(result,a1,l1);
            a1.removeLast();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l1 = new ArrayList<>();
        comb(nums, new ArrayList<>(),l1);
        return l1;
    }
}
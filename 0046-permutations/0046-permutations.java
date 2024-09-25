class Solution {
    List<List<Integer>> l1 ;
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
    public List<List<Integer>> permute(int[] nums) {
        l1  = new ArrayList<>();
        comb(nums, new ArrayList<>());
        return l1;
    }
}

// class Solution {
//     List<List<Integer>> l1 ;
//     void comb(int nums[],ArrayList <Integer> a1,int i)
//     {
//         if(a1.size() >= nums.length)
//         {
//             l1.add(new ArrayList(a1));
//             return;
//         }
//         for(int idx = i; idx<nums.length; idx++)
//         {   
//             if(!a1.contains(nums[idx]))
//             {
//                 a1.add(nums[idx]);
//                 comb(nums,a1,i);
//                 a1.remove(a1.size()-1);
//             }
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         l1 = new ArrayList<>();
//         comb(nums, new ArrayList<>(),0);
//         return l1;
//     }
// }
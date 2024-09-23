class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] filteredNums = Arrays.stream(nums).filter(n -> n > 0).toArray();
        
        Arrays.sort(filteredNums);
        
        int target = 1;
        for (int n : filteredNums) {
            if (n == target) {
                target++;
            } else if (n > target) {
                return target;
            }
        }
        
        return target;        
    }
}
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int min = 1;
//         HashSet<Integer> h1 = new HashSet<>();
//         for(int i : nums)
//         {   
//             h1.add(i);
//         }
//         while(true)
//         {
//             if(!h1.contains(min))
//                 return min;
//             min++;
//         }
//     }
// }

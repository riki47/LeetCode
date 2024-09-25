// class Solution {
//     public void moveZeroes(int[] nums) {
//         ArrayList <Integer> a1 = new ArrayList<>();
//         int count= 0;
//         for (int i = 0; i < nums.length; i++) {
//             if(nums[i] != 0)
//             {   
//                 a1.add(nums[i]);
//             }
//             else
//             {
//                 count++;
//             }
//         }
//         for(int i = 0;i<count;i++)
//         {
//             a1.add(0);
//         }
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = a1.get(i);
//         }
//     }
// }
class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        for(int i : nums)
        {
            if(i!=0)
            {
                nums[ind] = i;
                ind++;
            }
        }
        for(int i = ind;i<nums.length;i++)
        {
            nums[i] = 0;
        }
    }
}
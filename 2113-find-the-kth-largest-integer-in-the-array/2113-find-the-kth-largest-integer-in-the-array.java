// class Solution {
//     static int partition(String nums[],int start,int end)
//     {
//         String pivot = nums[end];
//         int i = start-1;
//         for(int j = start;j<nums.length;j++)
//         {
//             if( pivot.length()==nums[j].length())
//             {
//                 if(pivot.compareTo(nums[j]) > 0)
//                 {
//                     i++;
//                     String temp = nums[i];
//                     nums[i] = nums[j];
//                     nums[j] = temp;
//                 }
//             }
//             else if(pivot.length()>nums[j].length())
//             {
//                 i++;
//                 String temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//             }
//         }
//         String temp = nums[i+1];
//         nums[i+1] = nums[end];
//         nums[end] = temp;
//         return i+1;
//     }
//     static void quick(String nums[],int start,int end)
//     {
//         if(start<end)
//         {
//             int mid = partition(nums,start,end);
//             quick(nums,start,mid-1);
//             quick(nums,mid+1,end);
//         }
//     }
//     public String kthLargestNumber(String[] nums, int k) {
//         quick(nums,0,nums.length-1);
//         for(int i = 0;i<nums.length;i++)
//             System.out.print(nums[i]);
//         return nums[nums.length - k];
//     }
// }

import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
       BigInteger [] arr = new BigInteger[nums.length];
       for(int i =0;i<arr.length;i++)
       {
            arr[i] = new BigInteger(nums[i]);
       }
       Arrays.sort(arr);
       BigInteger res= arr[arr.length-k];
       return res.toString();
    }
}
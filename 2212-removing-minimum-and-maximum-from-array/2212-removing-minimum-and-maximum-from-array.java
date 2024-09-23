class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0,max = 0;
        int len = nums.length;
        for(int i = 0; i<len; i++)
        {
            int n = nums[i];
            if(nums[min]>n)
                min = i;
            if(nums[max]<n)
                max = i;
        }
        int s = Math.min(min,max);
        int bi = Math.max(min,max);
        
        int b = 1 + bi;
        int e = Math.min(b,len - s);
        int m1 = s+1 + len- bi;
        return Math.min(m1,e);
    }
}
// class Solution {
//     public int minimumDeletions(int[] nums) {
//         int minnum = Integer.MIN_VALUE;
//         int maxnum = Integer.MAX_VALUE;

//         int min = 0, max = 0;

//         for(int i = 0; i < nums.length; i++)
//         {
//             if(nums[i] > minnum) {minnum = nums[i]; min = i;}
//             if(nums[i] < maxnum) {maxnum = nums[i]; max = i;}
//         }
        
//         int n = nums.length;
//         int j = Math.min(min,max);
//         int k = Math.max(min,max);

//         int ans1 = n - j ;
//         int ans2 = Math.min(ans1,k+1);
       
//         int ans3 = j + 1 + n - k ;

//         return Math.min(ans2,ans3);
//     }
// }
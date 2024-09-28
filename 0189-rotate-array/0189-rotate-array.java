// class Solution {
//     public void rotate(int[] nums, int k) {
//         int len = nums.length;
//         int newa[] = new int[len];
//         int c = k%len;
//         for (int i = 0; i < len; i++) {
//             newa[c] = nums[i];
//             c = (c+1)%len;
//         }
//         for (int i = 0; i < len; i++) {
//             nums[i] = newa[i];
//         }
//     }
// }
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int c = k%len;
        reverse(nums,len-c,len-1);
        reverse(nums,0,len-c-1);
        reverse(nums,0,len-1);
    }
    void reverse(int []nums,int f,int s)
    {
        while(f<s)
        {
            int temp = nums[f];
            nums[f] = nums[s];
            nums[s] = temp;
            f++;
            s--;
        }
    }
}
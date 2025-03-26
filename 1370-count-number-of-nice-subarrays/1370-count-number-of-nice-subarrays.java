class Solution {
    //subarrays smaller than equal to k
    int subEq(int[] nums, int k, int n)
    {
        if(k<0)return 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        int subarr = 0;
        while(j < n)
        {
            sum += nums[j]%2;
            while(sum > k)
            {
                sum -= nums[i]%2;
                i++;
            }
            subarr += j-i+1;
            j++;
        }
        return subarr;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        //your code goes here
        int n = nums.length;
        return subEq(nums,k,n)-subEq(nums,k-1,n);
    }
}
class Solution {
    char ans  = 'a';
    void binsearch(char nums[],int target,int start,int end)
    {
        int mid = (start + end)/2;
        if(start<=end)
        {
            if(target-'a'>=nums[mid]-'a')
            {
                binsearch(nums, target, mid+1, end);
            }
            if(target-'a'< nums[mid]-'a')
            {
                ans = nums[mid];
                binsearch(nums, target, start, mid-1);
            }
        }
    }
    public char nextGreatestLetter(char[] letters, char target) {
        ans = letters[0];
        binsearch(letters,target,0,letters.length-1);
        return ans;
    }
}
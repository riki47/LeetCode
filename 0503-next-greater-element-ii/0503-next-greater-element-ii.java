class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        s1.add(nums[nums.length-1]);
        for(int i = nums.length-2; i >= 0; i--)
        {
            while(s1.peek() <= nums[i])
            {
                s1.pop();
                if(s1.isEmpty())
                    break;
            }
            s1.push(nums[i]);
        }
        for(int i = nums.length-1; i >= 0; i--)
        {
            int temp = 0;
            while(s1.peek() <= nums[i])
            {
                s1.pop();
                if(s1.isEmpty())
                    break;
            }
            if(!s1.isEmpty())
            {
                temp = s1.peek();
            }
            else
            {
                temp = -1;
            }
            s1.push(nums[i]);
            nums[i] = temp;
        }
        return nums;
    }
}
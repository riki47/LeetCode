class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s1 = new Stack<>();
        HashMap<Integer,Integer> h1 = new HashMap<>();

        s1.add(nums2[nums2.length-1]);
        h1.put(nums2[nums2.length-1],-1);

        for(int i = nums2.length-2; i >= 0; i--)
        {
            while(s1.peek() <= nums2[i])
            {
                s1.pop();
                if(s1.isEmpty())
                    break;
            }

            if(!s1.isEmpty())
                h1.put(nums2[i],s1.peek());
            else
                h1.put(nums2[i],-1);

            s1.push(nums2[i]);
        }
        for(int i = 0;i<nums1.length;i++)
        {
            nums1[i] = h1.get(nums1[i]); 
        }
        return nums1;
    }
}

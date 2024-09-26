// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> l1 = new ArrayList<List<Integer>>();
//         Set<List<Integer>> s1 = new HashSet<List<Integer>>(); 
//         Arrays.sort(nums);
//         int i = 0;
//         int j = nums.length-1;
//         int k = i+1;
//         int sum = 0;
//         for (i = 0; i<j; i++) {
//             k = i+1;
//             j = nums.length-1;
//             while(k<j)
//             {
//                 sum = nums[i]+nums[k]+nums[j];
//                 if(sum == 0)
//                 {
//                     ArrayList <Integer> a1 = new ArrayList<>();
//                     a1.add(nums[i]);
//                     a1.add(nums[k]);
//                     a1.add(nums[j]);
//                     s1.add(a1);
//                     k++;
//                 }
//                 else if(sum>0)
//                 {
//                     j--;
//                 }
//                 else
//                 {
//                     k++;
//                 }
//             }
//         }
//         Iterator <List<Integer>> g = s1.iterator();
//         while(g.hasNext())
//         {
//             l1.add(g.next());
//         }
//         return l1;
//     }
// }
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> l1 = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
            if(i>0 && nums[i] == nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum>0)
                {
                    k--;
                    while(j<k && nums[k+1] == nums[k])k--;
                }
                else if(sum<0)
                {
                    j++;
                    while(j<k && nums[j-1] == nums[j])j++;
                }
                else
                {
                    l1.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<k && nums[j-1] == nums[j])j++;
                }
            }
        }     
        return l1;   
    }
}
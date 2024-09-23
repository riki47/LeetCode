// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         HashMap <Integer,Integer> h1 = new HashMap<>();
//         int c = 1;
//         for(int i : nums)
//         {
//             if(i>0)
//             {
                
//                 if(h1.containsKey(i))
//                 {
//                     continue;
//                 }
//                 if(c != i)
//                 {
//                     return c;
//                 }
//                 h1.put(i,0);
//                 c++;
//             }
            
//         }

//         return c;
//     }
// }
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> h1 = new HashSet<>();
        for(int i : nums)
        {   
            h1.add(i);
        }
        for(int i = 1;i<Integer.MAX_VALUE;i++)
        {
            if(!h1.contains(i))
                return i;
        }
        return -1;
    }
}

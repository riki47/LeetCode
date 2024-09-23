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
        int min = 1;
        HashSet<Integer> h1 = new HashSet<>();
        for(int i : nums)
        {   
            h1.add(i);
        }
        min = 1;
        while(true)
        {
            if(!h1.contains(min))
                return min;
            min++;
        }
    }
}

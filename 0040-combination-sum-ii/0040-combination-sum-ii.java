// class Solution {
//     static boolean recur(ArrayList<List<Integer>> l1,ArrayList<Integer> a1,int num[],int i,int sum,int target)
//     {
//         if(sum == target)
//         {
//             l1.add(new ArrayList<>(a1));
//             return false;
//         }
//         if(i>=num.length || sum > target)
//         {
//             return false;
//         }
//         a1.add(num[i]);
//         boolean a = recur(l1,a1,num,i+1,sum+num[i],target);
//         a1.remove(a1.size()-1);
//         if(a == false)
//             return true;
//         while(i < num.length-1 && num[i] == num[i+1])
//             i++;
//         recur(l1,a1,num,i+1,sum,target);
//         return true;
//     }
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) 
//     {
//         Arrays.sort(candidates);
//         ArrayList<List<Integer>> h1 = new ArrayList<>();
//         recur(h1,new ArrayList<>(),candidates,0,0,target);
//         return h1;
//     }
// }

class Solution {
    ArrayList<List<Integer>> l1;
    void recur(ArrayList<Integer> a1, int num[], int sum, int idx, int target) 
    {
        if(sum == target)
        {
            l1.add(new ArrayList(a1));
            return;
        }
        if(sum>target)
        {
            return;
        }
        if(idx>=num.length)
        {
            return;
        }
        for(int i = idx;i<num.length;i++)
        {
            if(i>idx && num[i] == num[i-1])continue;
            if(i>=num.length || sum+num[i]>target)break;

            a1.add(num[i]);
            recur(a1,num,sum+num[i],i+1,target);
            a1.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        l1 = new ArrayList<>();
        recur(new ArrayList<>(),candidates,0,0,target);
        return l1;
    }
}
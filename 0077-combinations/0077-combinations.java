class Solution {
    static void comb(int n,int k,ArrayList<Integer> a1,List<List<Integer>> l1,int i)
    {
        if(a1.size()>=k)
            l1.add(new ArrayList<>(a1));
        for(int idx = i; idx<=n; idx++)
        {
            if(a1.size()>=k) break;
            a1.add(idx);
            comb(n,k,a1,l1,idx+1);
            a1.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> l1 = new ArrayList<List<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        comb(n,k,a1,l1,1);
        return l1;
    }
}
class Solution {
    void recur(List<Integer> a1,int n,int idx)
    {
        if(idx>n)return;
        a1.add(idx);
        for(int i = 0;i<10;i++)
        {
            if((idx*10 + i)>n)break;
            recur(a1,n,idx*10 + i);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> a1 = new ArrayList<>();
        for(int i = 1;i<10;i++)
        {
            recur(a1,n,i);
        }
        return a1;
    }
}
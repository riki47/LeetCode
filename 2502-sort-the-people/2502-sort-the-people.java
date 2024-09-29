class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap <Integer,String> t1 = new TreeMap<>();
        int n = names.length;
        for(int i = 0;i<n;i++)
        {
            t1.put(heights[i],names[i]);
        }
        String ans[] = new String[n];
        int i = n-1;
        for(Map.Entry<Integer,String> m1 : t1.entrySet())
        {
            ans[i] = m1.getValue();
            i--;
        }
        return ans;
    }
}
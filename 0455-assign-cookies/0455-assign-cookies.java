class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int j = 0;
        for(int i : s)
        {
            if(j<n && i>=g[j])
                j++;
        }
        return j;
    }
}
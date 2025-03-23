class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int j = 0;
        int i = 0;
        while(i < m && j<n)
        {
            if(s[i]>=g[j]) j++;
            i++;
        }
        return j;
    }
}
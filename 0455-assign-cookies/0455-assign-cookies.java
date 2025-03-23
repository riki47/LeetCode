class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int n = g.length, m = s.length;
        int j = 0, i = 0;
        while(i < m && j<n) if(s[i++]>=g[j]) j++;
        return j;
    }
}
class Solution {
    boolean recur(String s, String p, int i, int j,int n,int m) {
        if(j>=m)return i>=n;
        //  aab
        //  i
        //  a*b
        //  j
        boolean match = i<n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j+1<m && p.charAt(j+1) == '*')
        {
            return recur(s,p,i,j+2,n,m) || (match && recur(s,p,i+1,j,n,m));
        }
        else if((i<n && j<m )&& match)
        {
            return recur(s,p,i+1,j+1,n,m);
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int ns = s.length();
        int np = p.length();
        return recur(s,p,0,0,ns,np);
    }
}


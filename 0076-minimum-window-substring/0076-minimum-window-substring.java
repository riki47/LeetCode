class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();
        int starting = -1;
        int minLen = Integer.MAX_VALUE;
        int freq[] = new int[256];
        int cnt = 0;
        for(int k = 0;k<m;k++) //the needed characters
        {
            freq[t.charAt(k)]++;
        }
        while(j<n)
        {
            if(freq[s.charAt(j)]>0) // the element that we needed
                cnt++;
            freq[s.charAt(j)]--;
            while(cnt == m)
            {
                if(j-i+1 < minLen)
                {
                    minLen = j-i+1;
                    starting = i;
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)]>0)cnt--;
                i++;
            }
            j++;
        }
        if(starting == -1) return "";
        return s.substring(starting,starting+minLen);
    }
}
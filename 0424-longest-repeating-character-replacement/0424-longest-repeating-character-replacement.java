class Solution {
    public int characterReplacement(String si, int k) {
        int i = 0;
        int j = 0;
        char s[] = si.toCharArray(); 
        int n = si.length();
        int max = 0;
        int maxf = 0;
        HashMap <Character, Integer> h1 = new HashMap<>();
        while(j<n)
        {
            h1.put(s[j],h1.getOrDefault(s[j],0)+1);
            maxf = Math.max(maxf,h1.get(s[j]));
            if((j-i+1)-maxf>k)
            {
                h1.put(s[i],h1.get(s[i])-1);
                if(h1.get(s[i]) == 0)
                    h1.remove(s[i]);
                i++;
            }
            if((j-i+1)-maxf <= k)
                max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
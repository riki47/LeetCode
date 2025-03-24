class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;
        int maxf = 0;
        int h1[] = new int[26];
        while(j<n)
        {
            h1[s.charAt(j)-'A']++;
            maxf = Math.max(maxf,h1[s.charAt(j)-'A']);
            if((j-i+1)-maxf>k)
            {
                h1[s.charAt(i)-'A']--;
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
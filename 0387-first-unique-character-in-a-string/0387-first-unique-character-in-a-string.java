class Solution {
    public int firstUniqChar(String s) {
        char str[] = s.toCharArray();
        int map[] = new int[26];
        for(char c : str)
        {
            map[c-'a'] += 1;
        }
        int count = 0;
        for(char c : str)
        {
            if(map[c-'a'] == 1)
                return count;
            count++;
        }
        return -1;
    }
}
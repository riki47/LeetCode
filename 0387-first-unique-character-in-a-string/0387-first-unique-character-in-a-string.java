class Solution {
    public int firstUniqChar(String s) {
        HashMap <Character,Integer> h1 = new HashMap<Character,Integer>();
        for(char c : s.toCharArray())
        {
            h1.put(c,h1.getOrDefault(c,0)+1);
        }
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(h1.get(c) == 1)
                return count;
            count++;
        }
        return -1;
    }
}
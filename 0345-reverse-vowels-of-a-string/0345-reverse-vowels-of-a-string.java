class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        int n = s.length();
        char str[] = s.toCharArray();
        int start = 0;
        int end = n-1;
        while(start<end)
        {
            if(!vowelSet.contains(str[end]))
                end--;
            else if(!vowelSet.contains(str[start]))
                start++;
            else
            {
                char temp = str[end];
                str[end] = str[start];
                str[start] = temp;
                end--;
                start++;
            }
        }
        return String.valueOf(str);
    }
}
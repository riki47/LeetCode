class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet <String> h1 = new HashSet<>();
        for(int i : arr1)
        {
            String num1s = String.valueOf(i);
            String pre = "";
            for(char ch : num1s.toCharArray())
            {
                pre += ch;
                h1.add(pre);
            }
        }
        int max = 0;
        for(int i : arr2)
        {
            String num1s = String.valueOf(i);
            String pre = "";
            for(char ch : num1s.toCharArray())
            {
                pre += ch;
                if(h1.contains(pre))
                    max = Math.max(max,pre.length());
            }
        }
        return max;
    }
}
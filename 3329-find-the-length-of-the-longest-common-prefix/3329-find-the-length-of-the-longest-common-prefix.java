class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap <String,Integer> h1 = new HashMap<>();
        for(int i : arr1)
        {
            String num1s = String.valueOf(i);
            String pre = "";
            for(char ch : num1s.toCharArray())
            {
                pre += ch;
                h1.put(pre,h1.getOrDefault(pre,0)+1);
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
                if(h1.containsKey(pre))
                    max = Math.max(max,pre.length());
            }
        }
        return max;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int max = 0;
        HashMap <Integer, Integer> h1 = new HashMap<>();
        while(j<n)
        {
            h1.put(fruits[j],h1.getOrDefault(fruits[j],0)+1);
            if(h1.size()>2)
            {
                    h1.put(fruits[i],h1.get(fruits[i])-1);
                    if(h1.get(fruits[i]) == 0)
                        h1.remove(fruits[i]);
                i++;
            }
            if(h1.size()<=2)
                max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
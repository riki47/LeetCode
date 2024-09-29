class Solution {
    public int twoEggDrop(int n) {
        int sum = 0;
        int drops = 0;
        while(sum<n)
        {
            drops++;
            sum += drops;
        }
        return drops;
    }
}
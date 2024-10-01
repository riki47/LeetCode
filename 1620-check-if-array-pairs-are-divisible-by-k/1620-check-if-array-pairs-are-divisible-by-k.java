class Solution {
    public boolean canArrange(int[] arr, int k) {
        int na[] = new int[k];
        for(int i : arr)
        {
            int rem = (i%k+k)%k;
            na[rem]++;
        }
        if(na[0]%2 != 0) return false;
        for(int i = 1;i<=k/2;i++)
        {
            if(na[i] != na[k-i]) return false;
        }
        return true;
    }
}
class Solution {
    public void duplicateZeros(int[] arr) {
        int newa[] = new int[arr.length];
        int idx = 0;
        for(int i : arr)
        {
            if(idx>=arr.length)
                break;
            if(i == 0)
            {
                newa[idx] = 0;
                idx++;
            }
            if(idx>=arr.length)
                break;
            newa[idx] = i;
            idx++;
        }
        idx = 0;
        for(int i : newa)
        {
            arr[idx] = i;
            idx++;
        }
    }
}
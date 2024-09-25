class Solution {
    public void duplicateZeros(int[] arr) {
        int newa[] = new int[arr.length];
        int idx = 0;
        for(int i  = 0;idx<arr.length;i++)
        {
            newa[idx] = arr[i];
                idx++;
            if(arr[i] == 0 && idx<arr.length)
            {
                newa[idx] = 0;
                idx++;
            }
        }
        System.arraycopy(newa, 0, arr, 0, arr.length);
    }
}
// class Solution {
//      public void duplicateZeros(int[] arr) {

//         int[] tempArr = new int[arr.length];
         
//         for (int arrIndex = 0, tempIndex = 0; tempIndex < tempArr.length; arrIndex++) {
//             tempArr[tempIndex] = arr[arrIndex];

//             if (tempArr[tempIndex++] == 0 && tempIndex < tempArr.length) {
//                 tempArr[tempIndex++] = 0;
//             }
//         }
         
//         System.arraycopy(tempArr, 0, arr, 0, arr.length);
//     }
// }
// class Solution {
//     public void duplicateZeros(int[] arr) {
//         int newa[] = new int[arr.length];
//         int idx = 0;
//         for(int i : arr)
//         {
//             if(idx>=arr.length)
//                 break;
//             if(i == 0)
//             {
//                 newa[idx] = 0;
//                 idx++;
//             }
//             if(idx>=arr.length)
//                 break;
//             newa[idx] = i;
//             idx++;
//         }
//         idx = 0;
//         for(int i : newa)
//         {
//             arr[idx] = i;
//             idx++;
//         }
//     }
// }
class Solution {
     public void duplicateZeros(int[] arr) {

        int[] tempArr = new int[arr.length];
         
        for (int arrIndex = 0, tempIndex = 0; tempIndex < tempArr.length; arrIndex++) {
            tempArr[tempIndex] = arr[arrIndex];

            if (tempArr[tempIndex++] == 0 && tempIndex < tempArr.length) {
                tempArr[tempIndex++] = 0;
            }
        }
         
        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }
}
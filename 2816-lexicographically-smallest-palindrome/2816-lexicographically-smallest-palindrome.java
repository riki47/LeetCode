class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0, j = n - 1; i < n / 2; i++, j--)
            if(arr[i] != arr[j]){
                char smallOne = (char) Math.min(arr[i], arr[j]);
                arr[i] = arr[j] = smallOne;
            }
        return new String(arr);
    }
}
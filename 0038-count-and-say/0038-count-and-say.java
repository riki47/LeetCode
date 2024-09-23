class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i = 0;i<n-1;i++)
        {
            ArrayList<int[]> l1 = rle(sb);
            sb = rlestr(l1);
        }
        return sb.toString();
    }
    public static ArrayList<int[]> rle(StringBuilder sb)
    {
        ArrayList<int[]> a1 = new ArrayList<>();
        a1.add(new int[]{sb.charAt(0)-'0',1});
        int count = 1;
        for(int i = 1;i<sb.length();i++)
        {
            if(a1.get(count-1)[0] == sb.charAt(i)-'0')
                a1.get(count-1)[1]++;
            else
            {
                a1.add(new int[]{sb.charAt(i)-'0',1});
                count++;
            }
        }
        return a1;
    }
    public StringBuilder rlestr(ArrayList<int[]> l1)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<l1.size(); i++)
        {
            sb.append(l1.get(i)[1]);
            sb.append(l1.get(i)[0]);
        }
        return sb;
    }
}
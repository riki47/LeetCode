class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int ten = 0;
        //greedy cuz we first checkedd 10 rs nodte
        for(int i : bills)
        {
            if(i == 5) f++;

            else if(i == 10)
            {
                if(f>0) f--;
                else return false;
                ten++;
            }
            else
            {
                if(ten>0 && f>0)
                {
                    ten--;
                    f--;
                }
                else if(f>2) f -= 3;
                else return false;
            }
        }
        return true;
    }
}
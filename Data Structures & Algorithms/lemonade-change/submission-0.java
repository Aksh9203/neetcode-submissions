class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        int ten = 0;
        int five = 0;

        for(int i=0; i<n; i++){
            int b = bills[i];
            if(b == 5) five++;
            else{
                if(b == 10){
                    if(five > 0){
                        ten++;
                        five--;
                    }
                    else return false;
                }
                else{
                    if(ten > 0 && five > 0){
                        ten--;
                        five--;
                    }
                    else if(five > 2){
                        five = five - 3;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
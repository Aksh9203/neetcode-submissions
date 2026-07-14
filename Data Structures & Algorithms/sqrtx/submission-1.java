class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;

        int ans = 0;

        while(low <= high){
            long mid = low + (high - low)/2;

            if((long)(mid * mid) <= x){
                ans = (int)mid;
                low = (int)mid + 1;   
            }
            else{
                high = (int)mid - 1;
            }
        }
        return (int) ans;
    }
}
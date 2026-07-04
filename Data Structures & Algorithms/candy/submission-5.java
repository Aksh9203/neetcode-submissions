class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;

        int sum = 1;

        while(i<n){
            if(ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
            }

            int peak = 1;

            while(i<n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }

            int low = 1;

            while(i<n && ratings[i] < ratings[i-1]){
                sum += low;
                low++;
                i++;
            }

            if(low > peak){
                sum += low - peak;
            }
        }

        return sum;
    }
}
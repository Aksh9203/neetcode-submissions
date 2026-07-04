class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        // int[] right = new int[n];

        left[0] = 1;
        // right[n-1] = 1;

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
            else{
                left[i] = 1;
            }
        }

        
        int previous = 1;
        int curr = 1;
        int sum = Math.max(left[n-1],curr);

        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                previous = curr;
                curr = previous + 1;
            }
            else{
                curr = 1;
            }

            sum = sum + Math.max(left[i],curr);
        }

        return sum;
    }
}
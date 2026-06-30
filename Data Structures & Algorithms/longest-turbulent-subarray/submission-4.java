class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if(n==0) return 0;
        if(n==1) return 1;

        int r = 1;
        String dir = "";
        int cnt = 1;
        int max = Integer.MIN_VALUE;

        while(r<n){
            if(arr[r-1] > arr[r]){
                if(!dir.equals("D")) cnt++;
                else cnt = 2;
                
                dir = "D";
                max = Math.max(max,cnt);
            } 
            else if(arr[r-1] < arr[r]){
                if(!dir.equals("U")) cnt++;
                else cnt = 2;
            
                dir = "U";
                max = Math.max(max,cnt);
            }
            else if(arr[r-1] == arr[r]){
                cnt = 1;
                dir = "";
                max = Math.max(max,cnt);
            }
            r++;
        }
        return max;
    }
}
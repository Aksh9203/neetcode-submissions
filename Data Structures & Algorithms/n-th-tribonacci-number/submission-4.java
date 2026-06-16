// class Solution {
//     public int tribonacci(int n) {
//         int[] t = new int[n+1];
//         Arrays.fill(t,-1);
//         return tri(n,t);
//     }

//     public  int tri(int n, int[] t){
//         if(n == 0) return 0;
//         else if(n == 1) return 1;
//         else if(n == 2) return 1;
//         int res = 0;

//         if(t[n] != -1) return t[n];

//         for(int i=n; i>=3; i--){
//             res = tri(n-2,t) + tri(n-1,t) + tri(n-3,t);  
//         }
//     return t[n] = res;
//     }
// }

class Solution {
    public int tribonacci(int n) {
        int[] t = new int[n+1];

        if(n == 0) return 0;
        else if(n == 1 || n ==2) return 1;

        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        for(int i=3; i<=n; i++){
            t[i] = t[i-1] + t[i-2] + t[i-3];
        }
        
        return t[n];
    }
}
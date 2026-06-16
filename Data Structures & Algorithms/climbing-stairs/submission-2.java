// class Solution {
//     public int climbStairs(int n) {
//         int[] t = new int[n+1];
//         Arrays.fill(t,-1);
//         return climb(n,t);
//     }

//     public int climb(int n, int[] t){
//         if(n == 0) return 1;
//         if(n < 0) return 0;

//         if(t[n] != -1) return t[n];
        
//         int cost = 0;

//         for(int i=1; i<=2; i++){
//             cost += climb(n-i,t);
//         }

//         return t[n] = cost;
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;

        for(int i=2; i<=n; i++){
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }
}
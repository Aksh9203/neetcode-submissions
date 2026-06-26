// class Solution {
//     public int integerBreak(int n) {
//         int[] t = new int[n+1];
//         return find(n,t);
//     }

//     public int find(int n, int[] t){
//         if(n==1) return 1;

//         if(t[n] != 0) return t[n];

//         int prod = 0;
//         for(int i=1; i<n; i++){
//             prod = Math.max(prod, i * Math.max(n-i,find(n-i,t)));
//         }
//         return t[n] = prod;
//     }
// }

class Solution {
    public int integerBreak(int n) {
        int[] t = new int[n+1];

        for(int i=2; i<n+1; i++){
            t[i] = 0;
            for(int j=1; j<i; j++){
                t[i] = Math.max(t[i], j * Math.max(i-j,t[i-j]));
            }
        }
        return t[n];
    }
}
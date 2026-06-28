// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();

//         if(n<m) return 0;

//         int[][] t1 = new int[n+1][m+1];

//         return lcs(s,t,n,m,t1);
//     }

//     public int lcs(String s1, String s2, int n, int m, int[][] t){
//         if(m == 0) return 1;
//         if(n == 0) return 0;

//         if(t[n][m] != 0) return t[n][m];

//         if(s1.charAt(n-1) == s2.charAt(m-1)){
//             return t[n][m] = lcs(s1,s2,n-1,m-1,t) + lcs(s1,s2,n-1,m,t);
//         }
//         return t[n][m] = lcs(s1,s2,n-1,m,t); 
//     }
// }

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n<m) return 0;

        int[][] t1 = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            t1[i][0] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    t1[i][j] = t1[i-1][j-1] + t1[i-1][j];
                }
                else{
                    t1[i][j] = t1[i-1][j];
                }
            }
        }

        return t1[n][m];
    }
}
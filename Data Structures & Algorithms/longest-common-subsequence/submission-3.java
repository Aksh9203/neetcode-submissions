// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int[][] t = new int[n+1][m+1];

//         for(int[] t1 : t){
//             Arrays.fill(t1,-1);
//         }

//         return longSub(text1,text2,n,m,t);
//     }

//     public int longSub(String s1, String s2, int n, int m, int[][] t){
//         if(n == 0 || m == 0) return 0;

//         if(t[n][m] != -1) return t[n][m];

//         if(s1.charAt(n-1) == s2.charAt(m-1)){
//             return t[n][m] = 1 + longSub(s1,s2,n-1,m-1,t);
//         }

//         return t[n][m] = Math.max(longSub(s1,s2,n-1,m,t), longSub(s1,s2,n,m-1,t));
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] t = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        return t[n][m];
    }
}

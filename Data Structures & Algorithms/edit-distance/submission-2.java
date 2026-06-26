// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();

//         int[][] t = new int[n+1][m+1];
//         for(int[] t1 : t){
//             Arrays.fill(t1,-1);
//         }

//         return lcs(word1,word2,n,m,t);
//     }

//     public int lcs(String s1, String s2, int n, int m, int[][] t){
//         if(n == 0) return m;
//         if(m == 0) return n;

//         if(t[n][m] != -1) return t[n][m];

//         if(s1.charAt(n-1) == s2.charAt(m-1)){
//             return t[n][m] = lcs(s1,s2,n-1,m-1,t);
//         }
//         return t[n][m] = 1 + Math.min(lcs(s1,s2,n,m-1,t),Math.min(lcs(s1,s2,n-1,m,t),lcs(s1,s2,n-1,m-1,t)));
//     }
// }

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] t = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            t[i][0] = i;
        }

        for(int j=0; j<m+1; j++){
            t[0][j] = j;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1];
                }
                else{
                    t[i][j] = 1 + Math.min(t[i-1][j-1], Math.min(t[i][j-1],t[i-1][j]));
                }
            }
        }
        return t[n][m];
    }
}

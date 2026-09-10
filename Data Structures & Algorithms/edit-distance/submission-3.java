class Solution {
    int[][] t;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        t = new int[n + 1][m + 1];

        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return find(word1,word2,n,m);
    }

    private int find(String s1, String s2, int n, int m){
        if(n == 0) return m;
        if(m == 0) return n;

        if(t[n][m] != -1) return t[n][m];

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            return t[n][m] = find(s1,s2,n - 1, m - 1);
        }

        return t[n][m] = 1 + Math.min(find(s1,s2,n - 1,m - 1), Math.min(find(s1,s2,n,m - 1),find(s1,s2,n - 1,m)));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String sb = new StringBuilder(s).reverse().toString();

        int m = sb.length();
        int[][] t = new int[n+1][m+1];

        int max = 0;
        int index = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if((s.charAt(i-1) == sb.charAt(j-1))){
                    t[i][j] = 1 + t[i-1][j-1];
            
                    if (i - t[i][j] == n - j){
                        max = Math.max(max,t[i][j]);
                        if(t[i][j] >= max) {
                            index = i;
                        }
                    }
                    
                }
                else{
                    t[i][j] = 0;
                }
            }
            
        }

        StringBuilder s1 = new StringBuilder();

        while(max>0){
            s1.append(s.charAt(index-1));
            max--;
            index--;
        }
        return s1.toString();
    }
}

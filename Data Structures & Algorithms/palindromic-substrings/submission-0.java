class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        if(s.length() == 1) return 1;

        boolean[][] t = new boolean[s.length() + 1][s.length() + 1];

        for(int k=1; k<s.length()+1; k++){
            for(int i=0; i<=s.length() - k; i++){
                int j = i + k - 1;
                if(k==1){
                    t[i][j] = true;
                    count++;   
                }
                else if(k==2 && s.charAt(i) == s.charAt(j)){
                    t[i][j] = true;
                    count++;    
                }
                else if(k>=3 && s.charAt(i) == s.charAt(j) && t[i+1][j-1]){
                    t[i][j] = true;
                    count++;   
                }
            }
        }
    return count;
    }
}

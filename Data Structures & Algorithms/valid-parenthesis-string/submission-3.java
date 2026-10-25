class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int minOpenCnt = 0;
        int maxOpenCnt = 0;

        if(s.charAt(0) == ')') return false;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(c == '('){
                minOpenCnt++;
                maxOpenCnt++;
            }
            else if(c == ')'){
                minOpenCnt--;
                maxOpenCnt--;
            }
            else{
                minOpenCnt--;
                maxOpenCnt++;
            }

            if(minOpenCnt < 0) minOpenCnt = 0;
            if(maxOpenCnt < 0) return false;
        }
        return minOpenCnt == 0;
    }
}

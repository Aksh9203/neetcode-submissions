class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(n, ans, sb, 0,0);
        return ans;
    }

    public void generate(int n, List<String> ans, StringBuilder sb, int openCnt, int closeCnt){
        if(sb.length() == (2*n)){
            ans.add(sb.toString());
            return;
        }
        if(openCnt < n){
            sb.append("(");
            generate(n,ans,sb,openCnt + 1,closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeCnt < openCnt){
            sb.append(")");
            generate(n,ans,sb,openCnt,closeCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

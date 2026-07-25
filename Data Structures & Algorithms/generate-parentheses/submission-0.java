class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        gen(0, 0, n, ans, sb);
        return ans;
    }

    public void gen(int openCnt, int closeCnt, int n, List<String> ans, StringBuilder sb){
        if(openCnt == n && closeCnt == n){
            ans.add(sb.toString());
            return;
        }

        if(openCnt < n){
            sb.append("(");
            gen(openCnt + 1, closeCnt, n, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeCnt < openCnt){
            sb.append(")");
            gen(openCnt, closeCnt + 1, n, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

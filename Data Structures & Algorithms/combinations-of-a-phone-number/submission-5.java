class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

        List<String> ans = new ArrayList<>();

        if(n == 0) return ans;

        StringBuilder sb = new StringBuilder();
        find(digits,ans,sb,n,0);

        return ans;
    }

    private void find(String digits, List<String> ans, StringBuilder sb, int n, int idx){
        if(idx == n){
            ans.add(sb.toString());
            return;
        }

        char[] digit = digits.toCharArray();
        String letter = mapping[digit[idx] - '0'];

        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            find(digits,ans,sb,n,idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

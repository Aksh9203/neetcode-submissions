class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(digits.length() == 0) return ans;
        check(digits,ans,sb,0);
        return ans;
    }

    private void check(String digits, List<String> ans, StringBuilder sb, int idx){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char[] letters = digits.toCharArray();
        String letter = mapping[letters[idx] - '0'];

        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            check(digits,ans,sb,idx+1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

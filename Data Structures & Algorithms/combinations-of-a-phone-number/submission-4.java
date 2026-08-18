class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(digits.length() == 0) return ans;

        find(digits,ans,sb,0);
        return ans;
    }

    private void find(String digits, List<String> ans, StringBuilder sb, int idx){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = mapping[digit - '0'];

        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            find(digits,ans,sb,idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

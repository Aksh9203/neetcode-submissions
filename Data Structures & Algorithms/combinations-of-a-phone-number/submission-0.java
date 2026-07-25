class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;
        StringBuilder sb = new StringBuilder();

        letter(digits, ans, sb, 0);
        return ans;
    }

    public void letter(String digits, List<String> ans, StringBuilder sb, int idx){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = mapping[digit - '0'];

        for(int i = 0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            letter(digits, ans, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        } 
    }
}

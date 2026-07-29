class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(digits.length() == 0) return ans;

        check(digits,ans,sb,0);
        return ans;
    }

    public void check(String digits, List<String> ans, StringBuilder sb, int idx){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letter = mapping[digit - '0']; 

        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            check(digits,ans,sb,idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

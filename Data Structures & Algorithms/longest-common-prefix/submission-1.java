class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        String prefix = strs[0];

        for(int i=1; i<n; i++){
            while(strs[i].indexOf(prefix) == -1){
                prefix = prefix.substring(0,prefix.length() - 1);

                if(prefix.length() == 0) return "";
            }
        }

        return prefix;
    }
}
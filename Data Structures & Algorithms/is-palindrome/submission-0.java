class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println("Clean String :::::" + cleanStr);

        String lowerStr = cleanStr.toLowerCase();

        int l = 0;
        int r = lowerStr.length() - 1;

        while(l<r){
            if(lowerStr.charAt(l) != lowerStr.charAt(r)){
                return false;
            }
        l++;
        r--;
        }
        return true;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int[] str1 = new int[26];
        int[] str2 = new int[26];

        for(int i=0; i<s1.length(); i++){
            str1[s1.charAt(i) - 'a']++;
            // System.out.println("Str1 :::::" + Arrays.toString(str1));
            str2[s2.charAt(i) - 'a']++;
            // System.out.println("Str2 :::::" + Arrays.toString(str2));
        }

        if(Arrays.equals(str1,str2)){
            return true;
        }

        int l = 0;
        int r = s1.length()-1;
        int n = s2.length();

        while(r<n-1){
            str2[s2.charAt(l) - 'a']--;
            l++;
            r++;
            str2[s2.charAt(r) - 'a']++;

            if(Arrays.equals(str1,str2)){
                return true;
            }
        }
        return false;
    }
}

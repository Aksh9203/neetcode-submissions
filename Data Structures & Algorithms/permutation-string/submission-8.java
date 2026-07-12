class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int l = 0, r = 0;

        if(n > m) return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        for (char c : s1.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> mp1 = new HashMap<>();

        while(r < m){
            mp1.put(s2.charAt(r), mp1.getOrDefault(s2.charAt(r),0) + 1);
            if((r - l + 1) > n){
                if(mp1.get(s2.charAt(l)) > 1){
                    mp1.put(s2.charAt(l), mp1.getOrDefault(s2.charAt(l),0) - 1);
                }
                else{
                    mp1.remove(s2.charAt(l));
                }
                l++;
            }

            if(mp1.equals(mp)) return true;
            r++;
        }
        return false;
        
    }
}

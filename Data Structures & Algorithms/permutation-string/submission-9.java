class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        HashMap<Character,Integer> mp1 = new HashMap<>();
        HashMap<Character,Integer> mp2 = new HashMap<>();

        for(int i=0; i<n; i++){
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i),0) + 1);
        } 

        int l = 0, r = 0;

        while(r < m){
            mp2.put(s2.charAt(r), mp2.getOrDefault(s2.charAt(r),0) + 1);
            if(r - l + 1 > n){
                mp2.put(s2.charAt(l), mp2.getOrDefault(s2.charAt(l),0) - 1);
                if(mp2.getOrDefault(s2.charAt(l),0) == 0){
                    mp2.remove(s2.charAt(l));
                }
                l++;
            }  
            if(mp1.equals(mp2)) return true;
            r++;
        }
        return false;
    }
}

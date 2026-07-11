class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n) return "";

        HashMap<Character,Integer> mp = new HashMap<>();

        int sIndex = -1;
        int cnt = 0;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;

        for(char c : t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0) + 1);
        }

        while(r < n){
            if(mp.getOrDefault(s.charAt(r),0) > 0){
                cnt++;
            }
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) - 1);

            while(cnt == m){
                if(r - l + 1 < minLen){
                    minLen = Math.min(minLen, r - l + 1);
                    sIndex = l;
                }
                
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l),0) + 1);
                
                if(mp.getOrDefault(s.charAt(l),0) > 0){
                    cnt--;
                }   
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex,sIndex + minLen);
    }
}

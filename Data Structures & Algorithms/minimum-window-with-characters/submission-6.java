class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n < m) return "";

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0; i<m; i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0) + 1);
        }

        int l = 0, r = 0, minLen = Integer.MAX_VALUE, cnt = 0;
        int sIdx = -1;

        while(r < n){
            if(mp.getOrDefault(s.charAt(r),0) > 0){
                cnt++;
            }
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0) - 1);

            while(cnt == m){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    sIdx = l;
                }

                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0) + 1);
                if(mp.getOrDefault(s.charAt(l),0) > 0) cnt--;
                l++;
            }

            r++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx,sIdx+minLen);

    }
}

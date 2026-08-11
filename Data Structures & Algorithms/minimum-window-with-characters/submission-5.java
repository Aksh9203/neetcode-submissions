class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n < m) return "";

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0; i<m; i++){
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i),0) + 1);
        }

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int idx = -1;
        int cnt = 0;

        while(r < n){
            if(mp.getOrDefault(s.charAt(r),0) > 0){
                cnt++;
            }
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) - 1);


            while(cnt == m){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    idx = l;
                }

                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l),0) + 1);
                if(mp.get(s.charAt(l)) > 0) cnt--;
                l++;
            }
            r++;
        }

        return idx == -1 ? "" : s.substring(idx, idx + minLen);
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxf = Integer.MIN_VALUE;
        int n = s.length();
        int longest = 0;

        HashMap<Character,Integer> mp = new HashMap<>();

        while(r<n){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(maxf,mp.get(s.charAt(r)));

            if(r-l+1 - maxf > k){
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
                if(mp.get(s.charAt(l)) == 0) mp.remove(s.charAt(l));
                l++;
            }

            longest = Math.max(longest,r-l+1);
            System.out.println("maxf :::::" + maxf);
            r++;
        }
        return longest;
    }
}

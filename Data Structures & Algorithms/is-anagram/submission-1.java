class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;

        HashMap<Character,Integer> mp = new HashMap<>();
        HashMap<Character,Integer> tmp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0) + 1);
            tmp.put(t.charAt(i),tmp.getOrDefault(t.charAt(i),0) + 1);
        }

        return mp.equals(tmp);

    }
}

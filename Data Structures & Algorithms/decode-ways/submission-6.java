class Solution {
    int[] t;
    public int numDecodings(String s) {
        t = new int[s.length() + 1];
        Arrays.fill(t,-1);
        return decode(s,0);
    }

    private int decode(String s, int i){
        if(i == s.length()) return 1;

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(t[i] != -1) return t[i];

        int count = 0;
        count += decode(s,i+1);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))){
            count += decode(s,i+2);
        }

        return t[i] = count;
    }
}

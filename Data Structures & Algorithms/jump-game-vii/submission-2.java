// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         Boolean[] t = new Boolean[s.length()];
//         return reach(s,minJump,maxJump,0,t);
//     }

//     public boolean reach(String s, int minJ, int maxJ, int idx, Boolean[] t){
//         if(idx == s.length() - 1) return true;

//         if(t[idx] != null) return t[idx];

//         for(int i=minJ; i<=maxJ; i++){
//             int j = idx + i;

//             if(s.charAt(idx) == '1') return t[idx] = false;

//             if(j <= s.length() - 1){
//                 if(reach(s,minJ,maxJ,j,t)) return t[idx] = true;
//             }
//         }
//         return t[idx] = false;
//     }
// }

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] t = new boolean[s.length()];
        int cnt = 0;
        t[0] = true;

        for(int i=1; i<s.length(); i++){
            if(i - minJump >= 0 && t[i - minJump]) cnt++;

            if(i - maxJump - 1 >= 0 && t[i - maxJump - 1]) cnt--;

            if(cnt > 0 && s.charAt(i) == '0')  t[i] = true;
        }
        return t[s.length() - 1];
    }
}
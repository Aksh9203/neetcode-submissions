class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }

        while(r.size() > 0 && d.size() > 0){
            int r_top = r.poll();
            int d_top = d.poll();

            if(r_top > d_top){
                d.add(d_top + n);
            }
            else{
                r.add(r_top + n);
            }
        }

        return r.size() == 0 ? "Dire" : "Radiant";


    }
}
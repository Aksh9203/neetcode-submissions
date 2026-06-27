class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int tScore = 0;
        for(int i=0; i<n; i++){
            tScore += piles[i];
        }

        int[][] t = new int[n+1][n+1];
        for(int[] t1 : t) Arrays.fill(t1,-1);

        int alice = find(piles,0,n-1,t);
        if(alice > tScore - alice) return true;
        return false;
    }

    public int find(int[] piles, int l, int r, int[][] t){
        if(l>r) return 0;

        if(t[l][r] != -1) return t[l][r];

        boolean even = false;

        if((r-l)%2 == 0) even = true;

        int left = 0;
        int right = 0;

        if(even){
            left = piles[l];
            right = piles[r];
        }

        return t[l][r] = Math.max(find(piles,l+1,r,t) + left,find(piles,l,r-1,t) + right);
    }
}
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int M = 1;
        int alice = 1;
        int bob = 0;
        int[][][] t = new int[n+1][(2*n)+1][2];
        for(int[][] t2 : t){
            for(int[] t1 : t2){
                Arrays.fill(t1,-1);
            }
        }
        
        return find(piles,0,M,1,t);
    }

    public int find(int[] piles, int x, int M, int person, int[][][] t){
        if(x>=piles.length) return 0;

        if(t[x][M][person] != -1) return t[x][M][person];

        int stones = 0;
        int res;

        if(person == 1){
            res = -1;
        }
        else{
            res = Integer.MAX_VALUE;
        } 
        
        for(int i=1; i<=Math.min(2*M,piles.length - x); i++){
            stones += piles[x+i-1];

            if(person == 1){
                res = Math.max(res,stones + find(piles,x+i,Math.max(M,i),0,t));
            }
            else{
                res = Math.min(res,find(piles,x+i,Math.max(M,i),1,t));
            }
        }
        return t[x][M][person] = res;
    }
}
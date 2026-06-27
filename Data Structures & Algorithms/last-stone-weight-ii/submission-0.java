class Solution {
    public int lastStoneWeightII(int[] stones) {
        int range = 0;
        int n = stones.length;

        for(int i=0; i<n; i++){
            range += stones[i];
        }

        int diff = Integer.MAX_VALUE;
        boolean[][] t = new boolean[n+1][range+1];

        for(int j=0; j<=range/2; j++){
            if(subSum(stones,j,n,t)){
                diff = Math.min(diff,range - 2*j);
            }
        }
        return diff;
    }

    public boolean subSum(int[] stones, int target, int n, boolean[][] t){
        if(n==0 && target == 0) return true;
        if(n==0 && target > 0) return false;

        if(t[n][target] != false) return t[n][target];

        if(stones[n-1]<=target){
            return t[n][target] = subSum(stones,target - stones[n-1], n-1,t) || subSum(stones,target,n-1,t);
        }
        return t[n][target] = subSum(stones,target,n-1,t);
    }
}
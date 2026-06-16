class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] t = new int[cost.length + 1];
        Arrays.fill(t,-1);
        return Math.min(minClimb(cost,0,t),minClimb(cost,1,t));
    }

    public int minClimb(int[] cost, int i, int[] t){
        if(i>=cost.length) return 0;

        if(t[i] != -1) return t[i];

        int c1 = cost[i] + minClimb(cost,i+1,t);
        int c2 = cost[i] + minClimb(cost,i+2,t);

        return t[i] = Math.min(c1,c2);
    }
}

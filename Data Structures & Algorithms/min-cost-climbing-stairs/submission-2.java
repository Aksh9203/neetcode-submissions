// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] t = new int[cost.length + 1];
//         Arrays.fill(t,-1);
//         return Math.min(minClimb(cost,0,t),minClimb(cost,1,t));
//     }

//     public int minClimb(int[] cost, int i, int[] t){
//         if(i>=cost.length) return 0;

//         if(t[i] != -1) return t[i];

//         int c1 = cost[i] + minClimb(cost,i+1,t);
//         int c2 = cost[i] + minClimb(cost,i+2,t);

//         return t[i] = Math.min(c1,c2);
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] t = new int[cost.length + 1];

        t[0] = cost[0];
        t[1] = cost[1];
        
        for(int i=2; i<cost.length; i++){
            t[i] = cost[i] + Math.min(t[i-1],t[i-2]);
        }

        return Math.min(t[cost.length - 1],t[cost.length-2]);
    }
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int totalWeight = 0;

        for(int stone : stones){
            totalWeight += stone;
        }

        int[][] t = new int[n + 1][totalWeight/2 + 1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        int groupA = maxSubsetSum(stones,totalWeight/2,n, t);

        return totalWeight - (2 * groupA);
    }

    private int maxSubsetSum(int[] stones, int target, int n, int[][] t){
        if(n == 0 || target == 0) return 0;

        if(t[n][target] != -1) return t[n][target];

        if(stones[n - 1] <= target){
            int consider = stones[n - 1] + maxSubsetSum(stones, target - stones[n - 1], n - 1,t);
            int notConsider = maxSubsetSum(stones, target, n - 1,t);

            return t[n][target] = Math.max(consider, notConsider);
        }

        return t[n][target] = maxSubsetSum(stones, target, n - 1,t);
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalCost = 0, totalGas = 0;

        for(int i=0; i<n; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalGas < totalCost) return -1;

        int idx = 0;
        totalCost = 0;
        for(int i=0; i<n; i++){
            totalCost += gas[i] - cost[i];

            if(totalCost < 0){
                totalCost = 0;
                idx = (i + 1);
            }
        }

        return idx;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;

        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas) return -1;

        int travelCost = 0;
        int idx = 0;

        for(int i=0; i<n; i++){
            travelCost += gas[i] - cost[i];

            if(travelCost < 0){
                travelCost = 0;
                idx = i + 1;
            }
        }
        return idx;
    }
}

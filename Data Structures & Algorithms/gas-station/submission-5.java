class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalCost = 0;
        int totalGas = 0;

        for(int i=0; i<n; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalCost > totalGas) return -1;
        int total = 0;
        int result = 0;

        for(int i=0; i<n; i++){
            total = total + gas[i] - cost[i];
            if(total < 0){
                total = 0;
                result = i+1;
            }
        }
        return result; 
    }
}

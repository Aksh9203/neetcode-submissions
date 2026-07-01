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

        for(int i=0; i<n; i++){
            int total = gas[i] - cost[i];
            if(total < 0) continue;
            int j = (i+1)%n;
            while(j != i){
                total = total +  gas[j] - cost[j];

                if (total < 0) break;

                j = (j + 1) % n;
            }
            if(j == i) return i;
        }
        return -1;
    }
}

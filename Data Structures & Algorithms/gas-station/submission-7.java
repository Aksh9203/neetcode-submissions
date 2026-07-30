class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // int totalFuel = 0;

        for(int i=0; i<n; i++){
            int totalFuel = gas[i] - cost[i];
            if(totalFuel < 0) continue;
            int j = (i+1)%n;
            while(j<n){
                int fuel_insert = gas[j];
                int travel_cost = cost[j];

                totalFuel += fuel_insert - travel_cost;

                if(totalFuel < 0) break;
                j = (j+1)%n;
                
                if(j == i) return i;
            }
        }
        return -1;
    }
}

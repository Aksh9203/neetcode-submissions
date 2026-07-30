class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalFuel = 0;
        int travelCost = 0;

        for(int i=0; i<n; i++){
            totalFuel += gas[i];
            travelCost += cost[i];
        }

        if(totalFuel - travelCost < 0) return -1;

        int travel_total_cost = 0;
        int startIndex = 0;
        for(int i=0; i<n; i++){
            travel_total_cost += gas[i] - cost[i];
            if(travel_total_cost < 0){
                travel_total_cost = 0;
                startIndex = i+1;
            }
        }

        return startIndex;

    }
}

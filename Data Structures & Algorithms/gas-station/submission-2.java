class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int currentTotal = 0;
        // int total = 0;;
        int n = gas.length;

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

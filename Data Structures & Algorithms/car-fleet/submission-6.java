class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] fleet = new double[n][2];

        for(int i=0; i<n; i++){
            fleet[i][0] = position[i];
            fleet[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(fleet, (a,b) -> Double.compare(b[0],a[0]));

        double currentTime = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            double time = fleet[i][1];
            if(time > currentTime){
                cnt++;
                currentTime = time;
            }
        }
        return cnt;
    }
}

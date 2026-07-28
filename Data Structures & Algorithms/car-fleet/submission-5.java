class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] group = new double[n][2];

        for(int i=0; i<n; i++){
            group[i][0] = position[i];
            group[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(group, (a, b) -> Double.compare(b[0], a[0]));

        double time = 0;
        int cnt = 0;

        for(int i=0; i<group.length; i++){
            double currTime = group[i][1];
            if(currTime > time){
                cnt++;
                time = currTime;
            }
            
        }

        return cnt;
    }
}

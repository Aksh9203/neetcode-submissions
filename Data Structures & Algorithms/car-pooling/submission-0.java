class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip : trips){
            int source = trip[1];
            int destination = trip[2];
            
            diff[source] += trip[0];
            diff[destination] -= trip[0];
        }

        int currentPassenger = 0;
        for(int i=0; i<diff.length; i++){
            currentPassenger += diff[i];
            if(currentPassenger > capacity) return false;
        }
        return true;
    }
}
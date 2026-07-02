class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[target.length];

        for(int i=0; i<triplets.length; i++){
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) continue;
            max[0] = Math.max(max[0], triplets[i][0]);
            max[1] = Math.max(max[1], triplets[i][1]);
            max[2] = Math.max(max[2], triplets[i][2]);
        }

        boolean isEqual = Arrays.equals(max, target);
        return isEqual;
    }
}

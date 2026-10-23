class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        
        int[] cntWeight = new int[limit + 1];
        for(int p : people){
            cntWeight[p]++;
        }


        int idx = 0;
        for(int i=0; i<limit + 1; i++){
            while(cntWeight[i] > 0){
                people[idx++] = i;
                cntWeight[i]--;
            }
        }

        int l = 0, r = people.length - 1;
        int boat = 0;

        while(l <= r){
            boat++;
            if(people[l] + people[r] <= limit) l++;
            r--;
        }

        return boat;
    }
}
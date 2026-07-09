class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int i = 0;
        int j = n - 1;
        int cnt = 0;

        Arrays.sort(people);

        while(i<=j){
            if(people[i] + people[j] <= limit){
                cnt++;
                i++;
                j--;
            }
            else{
                cnt++;
                j--;
            }
        }
        return cnt;
    }
}
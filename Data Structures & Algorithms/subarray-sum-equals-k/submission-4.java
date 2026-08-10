class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);

        int sum = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];
            int prefix = sum - k;

            if(mp.containsKey(prefix)){
                cnt += mp.get(prefix);
            }
            mp.put(sum, mp.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}
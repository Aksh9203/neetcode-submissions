class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);

        int sum = 0, count = 0;


        for(int i=0; i<n; i++){
            sum += nums[i];
            int prefix = sum - k;

            if(mp.containsKey(prefix)){
                count += mp.get(prefix);
            }
            mp.put(sum,mp.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
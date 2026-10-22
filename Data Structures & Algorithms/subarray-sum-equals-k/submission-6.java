class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;
            int prefix = sum - k;

            if(mp.containsKey(prefix)){
                count += mp.get(prefix);
            }
            mp.put(sum,mp.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}
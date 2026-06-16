class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;

       HashMap<Integer,Integer> mp = new HashMap<>();
       for(int i = 0; i<n; i++){
            int val = nums[i];
            int diff = target - nums[i];

            while(mp.containsKey(diff)){
                return new int[]{mp.get(diff),i};
            }
        mp.put(nums[i],i);
       }
    return new int[]{};
    }
}

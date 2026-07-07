class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);

            mp.put(nums[i],mp.getOrDefault(nums[i],0) + 1);
        }

        int idx = 0;

        for(int i=min; i<=max; i++){
            while(mp.getOrDefault(i,0) > 0){
                nums[idx++] = i;
                mp.put(i,mp.getOrDefault(i,0) - 1);
            }
        }
        return nums;
    }
}
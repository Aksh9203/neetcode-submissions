class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0) + 1);
        }

        int idx = 0;

        for(int i=0; i<=2; i++){
            while(mp.getOrDefault(i,0) > 0){
                nums[idx++] = i;
                mp.put(i,mp.getOrDefault(i,0) - 1);
            }
        }
    }
}
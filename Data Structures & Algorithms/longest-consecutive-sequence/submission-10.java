class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }

        int max = 0;

        for(int i=0; i<n; i++){
            if(!s.contains(nums[i] - 1)){
                int min = nums[i];
                int cnt = 1;
                while(s.contains(min + 1)){
                    min = min + 1;
                    cnt++; 
                }
                max = Math.max(cnt,max);
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        int cnt = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            int value = nums[i];
            if(!st.contains(nums[i] - 1)){
                cnt = 1;
                while(st.contains(value + 1)){
                    cnt++;
                    value = value + 1;
                }
            }
            max = Math.max(max,cnt);
        }

        return max;
    }
}

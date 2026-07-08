class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }

        int cnt = 0;
        int max =0;

        for(int num : nums){
            if(!st.contains(num - 1)){
                int min = num;
                cnt = 1;
                while(st.contains(min + 1)){
                    cnt++;
                    min++;
                }
                max = Math.max(cnt,max);
            }
            else{
                cnt = 1;
            }

            // max = Math.max(cnt,max);
        }

        return max;
    }
}

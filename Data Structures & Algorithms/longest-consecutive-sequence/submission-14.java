class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        int count = 0;
        int maxLen = 0;
        
        for(int i=0; i<n; i++){
            int currVal = nums[i];
            count = 1;
            if(!st.contains(currVal - 1)){
                while(st.contains(currVal+1)){
                    count++;
                    currVal++;
                }
            }
            maxLen = Math.max(count,maxLen);
        }

        return maxLen;
    }
}

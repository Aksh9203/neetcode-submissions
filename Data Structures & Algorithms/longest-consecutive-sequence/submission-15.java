class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();

        for(int num : nums){
            st.add(num);
        }

        int count = 0, maxCount = 0;

        for(int num : nums){
            int currNum = num;

            if(!st.contains(currNum - 1)){
                count = 1;
                while(st.contains(currNum + 1)){
                    count++;
                    currNum++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
                nums[idx] = nums[i];
                idx++;
            }
        }

        return st.size();   
    }
}
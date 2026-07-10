class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        int l = 0, r = 0;
        HashSet<Integer> st = new HashSet<>();

        while(r<n){
            if((r - l) > k){
                st.remove(nums[l]);
                l++;
            }
            if(st.contains(nums[r])) return true;
            st.add(nums[r]);
            
            r++;
        }
        return false;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int idx = 0;
        int n = nums.length;

        while(l < n){
            if(l - 1 >= 0 && nums[l] == nums[l - 1]){
                l++;
            }
            else{
                nums[idx] = nums[l];
                idx++;
                l++;
            }
        }

        return idx;
    }
}
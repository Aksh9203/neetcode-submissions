class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(low == high) break;

            if(nums[low] > nums[high]){
                if(nums[low] <= nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }
            else{
                if(nums[low] <= nums[mid]){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
        }

        return nums[low];
    }
}

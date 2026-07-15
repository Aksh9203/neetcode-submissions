class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if (low == high) {
                break; // or return nums[low];
            }

            if(nums[low] > nums[high]){
                if(nums[mid] >= nums[low]){
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }
            else{
                if(nums[mid] >= nums[low]){
                    high = mid - 1;
                }
                else{
                    low = mid;
                }
            }
            
        }

        return nums[low];
    }
}

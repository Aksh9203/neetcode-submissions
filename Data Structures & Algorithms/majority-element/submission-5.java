class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int ele = Integer.MIN_VALUE;

        for(int num : nums){
            if(cnt == 0) {
                ele = num;
                cnt = 1;
            } else if(ele == num){
                cnt++;
            }else{
                cnt--;
            }
        }

        int finalCnt = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele) finalCnt++;
        }

        return finalCnt >= n/2 ? ele : 0;
    }
}
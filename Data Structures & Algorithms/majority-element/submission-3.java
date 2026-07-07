class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int ele = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] == ele){
                cnt++;
            }
            else if(cnt == 0){
                cnt = 1;
                ele = nums[i];
            }
            else{
                cnt--;
            }
        }
        
        int anCnt = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele) anCnt++;
        }

        if(anCnt > n/2) return ele;
        else return -1;
    }
}
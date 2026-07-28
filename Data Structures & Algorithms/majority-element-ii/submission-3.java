class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1){
                cnt1++;
            }
            else if(nums[i] == ele2){
                cnt2++;
            }
            else if(cnt1 == 0){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0){
                cnt2 = 1;
                ele2 = nums[i];
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        int cnt3 = 0, cnt4 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt3++;
            else if(nums[i] == ele2) cnt4++;
        }

        List<Integer> result = new ArrayList<>();
        if(cnt3 > n/3) result.add(ele1);
        if(cnt4 > n/3) result.add(ele2);

        return result;
    }
}
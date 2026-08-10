class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int ele1 = -1;
        int ele2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i=0; i<n; i++){
            if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
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

        int anCnt1 = 0;
        int anCnt2 = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) anCnt1++;
            else if(nums[i] == ele2) anCnt2++;
        }

        List<Integer> result = new ArrayList<>();

        if(anCnt1 > n/3) result.add(ele1);
        if(anCnt2 > n/3) result.add(ele2);

        return result;
    }
}
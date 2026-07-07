class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = -1;
        int ele2 = -1;

        List<Integer> ls = new ArrayList<>();

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

        int anCnt1 = 0;
        int anCnt2 = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) anCnt1++;
            else if(nums[i]== ele2) anCnt2++;
        }

        if(anCnt1 > n/3) ls.add(ele1);
        if(anCnt2 > n/3) ls.add(ele2);

        return ls;
    }
}
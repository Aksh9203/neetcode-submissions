class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int ele1 = 0, ele2 = 0, cnt1 = 0, cnt2 = 0;

        for(int num : nums){
            if(ele1 == num){
                cnt1++;
            } else if(ele2 == num){
                cnt2++;
            } else if(cnt1 == 0){
                ele1 = num;
                cnt1++;
            } else if(cnt2 == 0){
                ele2 = num;
                cnt2++;
            } else{
                cnt1--;
                cnt2--;
            }
        }

        int fCnt1 = 0, fCnt2 = 0;

        for(int num : nums){
            if(num == ele1) fCnt1++;
            if(num == ele2) fCnt2++;
        }

        List<Integer> ls = new ArrayList<>();

        if(fCnt1 > n/3) ls.add(ele1);
        if(fCnt2 > n/3) ls.add(ele2);

        return ls;
    }
}
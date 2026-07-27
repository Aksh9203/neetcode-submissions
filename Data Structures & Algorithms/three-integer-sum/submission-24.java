class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0; i<n-1; i++){

            if(i>0 && nums[i] == nums[i-1]) continue;

            int k = i + 1;
            int j = n-1;

            while(k<j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    ls.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    k++;
                    j--;

                    while(k < j && nums[k] == nums[k - 1]) k++;
                }
                else if(nums[i] + nums[j] + nums[k] > 0) j--;
                else k++;
            }
        }
        return ls;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0; i<n - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int k = i + 1;
            int j = n - 1;

            while(k < j){
                if(nums[i] + nums[j] + nums[k] > 0) j--;
                else if(nums[i] + nums[j] + nums[k] < 0) k++;
                else{
                    ls.add(Arrays.asList(nums[i],nums[k],nums[j]));
                    k++;
                    j--;

                    while(k < j && nums[k] == nums[k - 1]) k++;
                    while(k < j && nums[j] == nums[j + 1]) j--;

                }
            }
        }
        return ls;
    }
}

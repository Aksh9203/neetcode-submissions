class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;

        List<List<Integer>> ls = new ArrayList<>();

        while(i<n-2){
            while(i < n -2 && i > 0 && nums[i] == nums[i - 1]) i++;
            int k = i + 1;
            int j = n - 1;

            while(k<j){
                if(nums[i] + nums[k] + nums[j] < 0) k++;
                else if(nums[i] + nums[k] + nums[j] > 0) j--;
                else{
                    ls.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                    k++;
                    j--;
                    while(k < j && nums[k] == nums[k-1]) k++;
                    // while(k < j && nums[j] == nums[j + 1]) j--;    
                }
            }
            i++;
        }
        return ls;
    }
}

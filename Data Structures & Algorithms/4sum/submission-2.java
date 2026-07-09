class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ls = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while(i < n - 3){
            while(i < n - 3 && i > 0 && nums[i] == nums[i - 1]) i++;
            int k = i + 1;

            while(k < n - 2){
                while(k < n - 2 && k > i + 1 && nums[k] == nums[k - 1]) k++;
                int l = k + 1;
                int j = n - 1;

                while(l < j){
                    long sum = (long) nums[i] + nums[k] + nums[l] + nums[j];
                    if(sum < target) l++;
                    else if(sum > target) j--;
                    else{
                        ls.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[l], nums[j])));
                        l++;
                        j--;
                        while(l < j && nums[l] == nums[l - 1]) l++;
                    }
                }
                k++;
            }
            i++;
        }
        return ls;
    }
}
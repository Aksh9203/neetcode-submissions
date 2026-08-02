class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int k = i + 1; k<n-1 ; k++){
                if(k>i + 1 && nums[k] == nums[k - 1]) continue;

                int j = n - 1;
                int l = k + 1;

                while(l < j){
                    long sum = (long) nums[i] + nums[k] + nums[l] + nums[j];
                    if(sum > target) j--;
                    else if(sum < target) l++;
                    else{
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[k],nums[l],nums[j])));
                        l++;
                        j--;

                        while(l < j && nums[l] == nums[l-1]) l++;
                    }
                }
            }
        }
        return result;
    }
}
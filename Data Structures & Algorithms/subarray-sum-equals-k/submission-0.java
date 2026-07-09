class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        int prefix = 0;
        int cnt = 0;
        mp.put(0,1);


        for(int i=0; i<n; i++){
            prefix = prefix + nums[i];
            int ans = prefix - k;

            if(mp.containsKey(ans)){
                cnt += mp.get(ans);  
            }
            mp.put(prefix,mp.getOrDefault(prefix,0) + 1);
        }
        return cnt;
    }
}
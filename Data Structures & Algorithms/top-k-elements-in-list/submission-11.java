class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        List<Integer>[] freq = new List[n + 1];
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<=n; i++){
            freq[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int idx = 0;
        int[] res = new int[k];
        
        for(int i=n; i>0; i--){
            for(int n1 : freq[i]){
                res[idx] = n1;
                idx++;
                if(idx == k) return res;
            }
        }
        return res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        List<Integer>[] freq = new List[n+1];

        for(int i=0; i<=n; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num,0)+ 1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            freq[(entry.getValue())].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for(int i=n; i>=0 && idx < k; i--){
            for(int n1 : freq[i]){
                result[idx] = n1;
                idx++; 
                if(idx == k) return result;
            }
        }
        return result;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> maxP = new PriorityQueue<>((a,b) -> mp.get(a) - mp.get(b));

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            maxP.add(entry.getKey());
            if(maxP.size() > k) maxP.poll();
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            int top = maxP.poll();
            result[i] = top;
        }

        return result;
    }
}

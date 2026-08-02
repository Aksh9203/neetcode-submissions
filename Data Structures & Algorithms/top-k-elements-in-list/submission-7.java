class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
            while(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            int[] top = pq.poll();
            int value = top[0];
            result[i] = value;
        }

        return result;
    }
}

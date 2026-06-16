class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);       
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            mp.put(entry.getKey(),entry.getValue());
            System.out.println("mp :::::::" + mp);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>
                (Comparator.comparing((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed());

        maxHeap.addAll(mp.entrySet());
        System.out.println("MaxHeap ::::" + maxHeap);
        
        
        for(int j=0; j<k; j++){
            if (!maxHeap.isEmpty()) {
                arr.add(maxHeap.poll().getKey());
            }
            System.out.println("Array :::::::" + arr);
        }
    return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}

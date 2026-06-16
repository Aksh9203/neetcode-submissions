class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(int value : mp.keySet()){
            int freq = mp.get(value);
            System.out.println("Freq :::::::" + freq);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(value);
        }

        int[] result = new int[k];
        int counter  = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            // If a bucket for this frequency exists (is not null)...
            if (bucket[i] != null) {
                // ...go through each number in that bucket.
                for (int num : bucket[i]) {
                    // Add the number to our result array.
                    result[counter] = num;
                    counter++;

                    // Return the result immediately.
                    if (counter == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    //     List<Integer> arr = new ArrayList<>();

    //     for(int i=0; i<nums.length; i++){
    //         mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);       
    //     }

    //     for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
    //         mp.put(entry.getKey(),entry.getValue());
    //         System.out.println("mp :::::::" + mp);
    //     }

    //     PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>
    //             (Comparator.comparing((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed());

    //     maxHeap.addAll(mp.entrySet());
    //     System.out.println("MaxHeap ::::" + maxHeap);
        
        
    //     for(int j=0; j<k; j++){
    //         if (!maxHeap.isEmpty()) {
    //             arr.add(maxHeap.poll().getKey());
    //         }
    //         System.out.println("Array :::::::" + arr);
    //     }
    // return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}

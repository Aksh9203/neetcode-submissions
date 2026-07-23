class KthLargest {
    PriorityQueue<Integer> pq;
    int kth;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b) -> a - b);
        kth = k;
        for(int i = 0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > kth){
            pq.poll();
        }
        return pq.peek();
    }
}

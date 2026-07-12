class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] max = new int[n - k + 1];

        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            
            

            dq.add(i);

            if(i >= k - 1){
                max[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return max;
    }
}

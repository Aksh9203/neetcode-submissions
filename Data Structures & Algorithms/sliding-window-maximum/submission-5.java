class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.add(i);

            if(i - k + 1 >= 0){
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}

class Solution {
    int[] t;
    public int rob(int[] nums) {
        int n = nums.length;
        t = new int[n + 1];
        Arrays.fill(t,-1);

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);

        // 1. Run first branch
        Arrays.fill(t, -1);
        int choice1 = chor(nums, 0, n - 1);
        
        // 2. Reset and run second branch
        Arrays.fill(t, -1);
        int choice2 = chor(nums, 1, n);
        
        // 3. Reset and run third branch
        Arrays.fill(t, -1);
        int choice3 = chor(nums, 2, n);
        
        return Math.max(choice1, Math.max(choice2, choice3));
    }

    private int chor(int[] nums, int i, int n){
        if(i >= n) return 0;

        if(t[i] != -1) return t[i];

        int c1 = nums[i] + Math.max(chor(nums,i + 2,n),chor(nums,i + 3,n));

        return t[i] = c1;
    }
}

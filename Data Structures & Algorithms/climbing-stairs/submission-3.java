class Solution {
    public int climbStairs(int n) {
        int[] t = new int[n + 1];
        Arrays.fill(t,-1);
        return climb(n,t);
    }

    private int climb(int n, int[] t){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(t[n] != -1) return t[n];
        return t[n] = climb(n - 1,t) + climb(n - 2,t);
    }
}

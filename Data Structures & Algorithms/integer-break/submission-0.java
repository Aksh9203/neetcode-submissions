class Solution {
    public int integerBreak(int n) {
        int[] t = new int[n+1];
        return find(n,t);
    }

    public int find(int n, int[] t){
        if(n==1) return 1;

        if(t[n] != 0) return t[n];

        int prod = 0;
        for(int i=1; i<n; i++){
            prod = Math.max(prod, i * Math.max(n-i,find(n-i,t)));
        }
        return t[n] = prod;
    }
}
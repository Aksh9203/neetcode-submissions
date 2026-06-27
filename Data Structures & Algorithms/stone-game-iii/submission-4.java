class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] t = new int[n+1];
        // Arrays.fill(t,-1);
        int score = find(stoneValue,0,t);

        if(score > 0) return "Alice";
        else if(score == 0) return "Tie";
        else return "Bob";
    }

    public int find(int[] stone, int idx, int[] t){
        int n = stone.length;
        if(idx>=n) return 0;

        if(t[idx] != 0) return t[idx];

        int res = Integer.MIN_VALUE;

        res = Math.max(res, stone[idx] - find(stone,idx+1,t));

        if(idx+1<n){
            res = Math.max(res,stone[idx] + stone[idx+1] - find(stone,idx+2,t));
        }

        if(idx+2<n){
            res = Math.max(res,stone[idx] + stone[idx+1] + stone[idx+2] - find(stone,idx+3,t));
        }

        return t[idx] = res;
    }
}


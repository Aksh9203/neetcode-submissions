class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = 0;
        int high = (n*n) - 1;

        int result = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            boolean[][] vis = new boolean[n][n];

            if(target(mid,0,0,vis,grid)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean target(int mid, int r, int c, boolean[][] vis, int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] == true || grid[r][c] > mid){
            return false;
        }

        vis[r][c] = true;

        if(r == grid.length - 1 && c == grid[0].length - 1){
            return true;
        }

        boolean check = target(mid, r + 1, c, vis, grid) ||
                        target(mid, r - 1, c, vis, grid) ||
                        target(mid, r, c + 1, vis, grid) ||
                        target(mid, r, c - 1, vis, grid);

        return check;
    }
}

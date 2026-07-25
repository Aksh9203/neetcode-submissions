class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;


        boolean[][] pac = new boolean[n][m];
        boolean[][] atlan = new boolean[n][m];

        for(int i=0; i<m; i++){
            dfs(heights,0,i,pac,0);
            dfs(heights,n - 1,i,atlan,0);
        }

        for(int i=0; i<n; i++){
            dfs(heights,i,m-1,atlan,0);
            dfs(heights,i,0,pac,0);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pac[i][j] == true && atlan[i][j] == true){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] h, int row, int col, boolean[][] vis, int prev){
        if(row < 0 || row >= h.length || col < 0 || col >= h[0].length || h[row][col] < prev || vis[row][col] == true){
            return;
        }

        prev = h[row][col];
        vis[row][col] = true;

        dfs(h,row + 1, col, vis, prev);
        dfs(h,row - 1, col, vis, prev);
        dfs(h,row, col + 1, vis, prev);
        dfs(h,row, col - 1, vis, prev);
    }
}

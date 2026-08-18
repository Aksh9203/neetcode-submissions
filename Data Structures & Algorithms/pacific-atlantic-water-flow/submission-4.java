class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0; i<n; i++){
            dfs(heights,i,0,pacific,0);
            dfs(heights,i,m-1,atlantic,0);
        }

        for(int i=0; i<m; i++){
            dfs(heights,0,i,pacific,0);
            dfs(heights,n-1,i,atlantic,0);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prev){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] == true || heights[row][col] < prev){
            return;
        }

        visited[row][col] = true;
        prev = heights[row][col];

        dfs(heights,row+1,col,visited,prev);
        dfs(heights,row-1,col,visited,prev);
        dfs(heights,row,col+1,visited,prev);
        dfs(heights,row,col-1,visited,prev);
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];

        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        int[] ans = new int[numCourses];

        while(!q.isEmpty()){
            int top = q.poll();

            ans[count++] = top;

            for(int j : adj.get(top)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }

        if(count != numCourses) return new int[]{};

        return ans;
    }
}

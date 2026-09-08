class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];

            adj.get(v).add(u);
        }

        int[] inDegree = new int[numCourses];

        for(int[] prerequisite : prerequisites){
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int top = q.poll();
            ans[idx++] = top;

            for(int j : adj.get(top)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }

        return idx == numCourses ? ans : new int[]{};
    }
}

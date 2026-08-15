class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];

            adj.get(u).add(v);
        }

        int[] inDegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            inDegree[prerequisite[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);

            for(int j : adj.get(top)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }

        return ans.size() == numCourses;
    }
}

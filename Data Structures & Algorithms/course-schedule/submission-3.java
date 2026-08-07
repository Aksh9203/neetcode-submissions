class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

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

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int top = q.poll();
            result.add(top);

            for(int dependent : adj.get(top)){
                inDegree[dependent]--;
                if(inDegree[dependent] == 0){
                    q.add(dependent);
                }
            }
        }

        return numCourses == result.size();
    }
}

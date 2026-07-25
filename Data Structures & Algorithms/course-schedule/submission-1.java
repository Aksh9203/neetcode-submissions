class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];

        for(int[] edge : prerequisites){
            inDegree[edge[1]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();

        while(!q.isEmpty()){
            int top = q.poll();
            ls.add(top);

            for(int j : adj.get(top)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }

        if(ls.size() != numCourses){
            return false;
        }

        return true;

    }
}

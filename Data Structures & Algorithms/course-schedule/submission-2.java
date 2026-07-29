class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
        }

        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites){
            inDegree[pre[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> ls = new ArrayList<>();

        while(!q.isEmpty()){
            int top = q.poll();
            ls.add(top);

            for(int course : adj.get(top)){
                inDegree[course]--;
                if(inDegree[course] == 0){
                    q.add(course);
                }
            }
        }

        return ls.size() == numCourses;
    }
}

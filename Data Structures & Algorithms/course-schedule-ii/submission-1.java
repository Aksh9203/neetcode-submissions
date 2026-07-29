class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
        }

        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites){
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int top = q.poll();
            result[idx] = top;
            idx++;

            for(int course : adj.get(top)){
                inDegree[course]--;
                if(inDegree[course] == 0){
                    q.add(course);
                }
            }
        }

        return idx == numCourses ? result : new int[]{};
    }
}

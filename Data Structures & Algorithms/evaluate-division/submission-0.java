class Pair{
    String letter;
    double val;

    public Pair(String letter, double val){
        this.letter = letter;
        this.val = val;
    }
}

class Solution {

    HashMap<String, List<Pair>> adj = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size(); i++){
            List<String> ls = equations.get(i);
            adj.computeIfAbsent(ls.get(0), k -> new ArrayList<>()).add(new Pair(ls.get(1), values[i]));
            adj.computeIfAbsent(ls.get(1), k -> new ArrayList<>()).add(new Pair(ls.get(0), 1.0/values[i]));
        }

        int n = queries.size();
        double[] res = new double[n];
        for(int i=0; i<n; i++){
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return res;
    }

    public double dfs(String src, String des, HashSet<String> st){
        if(!adj.containsKey(src)) return -1;
        if(st.contains(src)) return -1;
        if(src.equals(des)) return 1;
        st.add(src);

        for(Pair neighbors : adj.get(src)){
            double ans = dfs(neighbors.letter,des,st);
            if(ans != -1){
                return ans * neighbors.val;
            }
        }

        return -1;
    }
}
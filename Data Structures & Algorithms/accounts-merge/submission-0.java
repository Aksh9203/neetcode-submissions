class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;
        else if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                if(!mp.containsKey(accounts.get(i).get(j))){
                    mp.put(accounts.get(i).get(j),i);
                }
                else{
                    dsu.union(mp.get(accounts.get(i).get(j)),i);
                }
            }
        }

        List<List<String>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            String email = entry.getKey();
            int find = dsu.find(entry.getValue());
            adj.get(find).add(email); 
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(adj.get(i).isEmpty()) continue;
            Collections.sort(adj.get(i));

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));
            for(String s : adj.get(i)){
                temp.add(s);
            }

            ans.add(temp);
        }
        return ans;
    }
}
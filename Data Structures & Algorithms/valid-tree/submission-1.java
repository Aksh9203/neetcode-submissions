class DSU{
    int[] parent;
    int[] size;

    DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<n; i++){
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

        if(pv == pu) return;
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
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            if(dsu.find(u) == dsu.find(v)){
                return false;
            }

            dsu.union(u,v);
        }
        return true;
    }
}

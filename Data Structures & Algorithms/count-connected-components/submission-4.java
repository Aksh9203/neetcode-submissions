class DSU{
    int[] size;
    int[] parent;

    public DSU(int n){
        size = new int[n + 1];
        parent = new int[n + 1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = i;
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
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        int count = 0;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) != dsu.find(v)){
                dsu.union(u,v);
                count++;
            }
        }

        return n - count;
    }
}

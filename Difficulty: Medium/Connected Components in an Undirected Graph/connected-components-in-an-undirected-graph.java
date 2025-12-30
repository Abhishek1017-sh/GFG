class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> comp,int visited[]){
        visited[node]=1;
        comp.add(node);
        for(int it:adj.get(node)){
            if(visited[it]!=1){
                dfs(it,adj,comp,visited);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[] = new int[V];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0;i<V;i++){
            
            if(visited[i]!=1){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i,adj,comp,visited);
                comps.add(comp);
            }
            
        }
        return comps;
    }
}
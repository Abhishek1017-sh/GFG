class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
        }
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathvis)==true) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,List<List<Integer>> adj,int[] vis,int[] pathvis)
    {
        vis[node]=1;
        pathvis[node]=1;
        for(int nei:adj.get(node)){
            if(vis[nei]==0){
                if(dfs(nei,adj,vis,pathvis)==true){
                    return true;
                }
            }
            else if(pathvis[nei]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
}
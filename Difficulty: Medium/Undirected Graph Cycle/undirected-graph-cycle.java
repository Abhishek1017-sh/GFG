class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            vis[i]=false;
        }
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(helper(vis,V,adj,i)) return true;
            }
        }
        return false;
    }
    static boolean helper(boolean[] vis,int v,ArrayList<ArrayList<Integer>> adj,int i){
        vis[i]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,-1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int nbr:adj.get(node)){
                if(!vis[nbr]){
                    vis[nbr]=true;
                    q.add(new Pair(nbr,node));
                }
                else if(parent!=nbr){
                    return true;
                }
            }
        }
        return false;
    }
}
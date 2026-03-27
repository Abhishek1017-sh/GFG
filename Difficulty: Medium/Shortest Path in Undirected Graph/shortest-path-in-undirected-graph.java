
class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] dist=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it]=1+dist[node];
                    q.add(it);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==(int)1e9) dist[i]=-1;
        }
        return dist;
    }
}

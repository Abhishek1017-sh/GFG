class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[V];
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            indeg[e[1]]++;
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            cnt++;
            topo.add(node);
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }
        if(cnt==V) return false;
        return true;
    }
}
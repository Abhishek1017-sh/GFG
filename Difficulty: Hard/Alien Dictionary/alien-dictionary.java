class Solution {
    public String findOrder(String[] words) {
        // code here
        int k=26;
        int n=words.length;
        int count=0;
        int[] present=new int[k];
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                int x=words[i].charAt(j)-'a';
                if(present[x]==0){
                    present[x]=1;
                    count++;
                }
            }
        }
        ArrayList<HashSet<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new HashSet<>());
        }
        for(int i=1;i<n;i++){
            String s1=words[i-1];
            String s2=words[i];
            int size=Math.min(s1.length(),s2.length());
            boolean flag=false;
            for(int j=0;j<size;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int u=s1.charAt(j)-'a';
                    int v=s2.charAt(j)-'a';
                    if(!adj.get(u).contains(v)){
                        adj.get(u).add(v);
                    }
                    flag=true;
                    break;
                }
            }
            if(!flag && s1.length()>s2.length()) return "";
        }
        int[] indeg=new int[k];
        for(int i=0;i<k;i++){
            for(int e:adj.get(i)){
                indeg[e]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(present[i]==1 && indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }
        if(ans.size()!=count) return "";
        StringBuilder sb=new StringBuilder();
        for(int i:ans){
            sb.append((char)(i+'a'));
        }
        return sb.toString();
    }
}
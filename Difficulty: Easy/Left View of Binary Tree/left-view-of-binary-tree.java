/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        while(queue.size()>0){
            List<Integer> ls=new ArrayList<>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                Node n=queue.poll();
                ls.add(n.data);
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            list.add(ls.get(0));
        }
        return list;
    }
}
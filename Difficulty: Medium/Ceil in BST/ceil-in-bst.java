/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
    int findCeil(Node root, int key) {
        // code here
        int ans=Integer.MAX_VALUE;
        while(root!=null){
            if(root.data>=key){
                ans=Math.min(root.data,ans);
                root=root.left;
            }
            else root=root.right;
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
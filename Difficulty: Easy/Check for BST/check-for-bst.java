/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    void solve(ArrayList<Integer> inorder,Node root){
        if(root==null) return;
        solve(inorder,root.left);
        inorder.add(root.data);
        solve(inorder,root.right);
    }
    boolean isBST(Node root) {
        // code here.
        ArrayList<Integer> inorder=new ArrayList<>();
        solve(inorder,root);
        for(int i=0;i<inorder.size()-1;i++){
            if(inorder.get(i+1)<inorder.get(i)){
                return false;
            }
        }
        return true;
    }
}
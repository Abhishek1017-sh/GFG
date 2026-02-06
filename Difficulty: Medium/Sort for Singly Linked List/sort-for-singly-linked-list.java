// User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node insertionSort(Node head_ref) {
        // code here
        if(head_ref==null || head_ref.next==null){
            return head_ref;
        }
        
        Node mid=middle(head_ref);
        Node rightmid=mid.next;
        mid.next=null;
        
        Node left=insertionSort(head_ref);
        Node right=insertionSort(rightmid);
        
        return merge(left,right);
    }
    static Node middle(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
        Node dummy=new Node(0);
        Node curr=dummy;
        while(left!=null && right!=null){
            if(left.data<=right.data){
                curr.next=left;
                left=left.next;
            }
            else{
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        curr.next=(left!=null) ? left : right; 
        return dummy.next;
    }
}
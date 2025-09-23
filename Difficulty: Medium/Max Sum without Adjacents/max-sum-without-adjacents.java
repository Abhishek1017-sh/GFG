// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int[] store=new int[arr.length];
        Arrays.fill(store,-1);
        store[0]=arr[0];
        store[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            store[i]=Math.max(store[i-1],store[i-2]+arr[i]);
        }
        return store[n-1];
    }
}
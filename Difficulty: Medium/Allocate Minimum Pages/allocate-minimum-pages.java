//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(k>n) return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int i:arr){
            high+=i;
            low=Math.max(i,low);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(arr,mid,k)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean isValid(int[] arr,int mid,int k){
        int stu=1,count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+count<=mid){
                count+=arr[i];
            }
            else{
                stu++;
                count=arr[i];
                if(stu>k) return false;
            }
        }
        return true;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        if(arr== null || arr.length==0){
            return 0;
        }
        int maxpro=arr[0];
        int minpro=arr[0];
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            int num=arr[i];
            if(num<0){
                int temp=maxpro;
                maxpro=minpro;
                minpro=temp;
            }
            maxpro=Math.max(num,maxpro*num);
            minpro=Math.min(num,minpro*num);
            
            ans=Math.max(ans,maxpro);
        }
        return ans;
    }
}
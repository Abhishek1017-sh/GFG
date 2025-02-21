//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        // code here
        int n = s.length();
        int open=0; int close=0;
        int ans=0;
        //left to right
         for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(') 
            {
                open++;
            }
            else{
                close++;
            } 
            
            if(open == close) 
            {
                ans = Math.max(ans, open*2);
            }
            else{ 
                if(close > open)  
                    close=open=0;
            }
         }
         open=0; close=0;
         for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch=='(') open++;
            else close++;
            
           if(open == close) ans = Math.max(ans, open*2);
            
            else if(open > close)  close=open=0;
         }
         return ans;
    }
}
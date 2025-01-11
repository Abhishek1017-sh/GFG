//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        if(s==null || s.isEmpty()){
            return 0;
        }
        int max=0;
        int left=0;
        HashSet<Character> ans=new HashSet<>();
        for(int right=0;right<s.length();right++){
            char cu=s.charAt(right);
            while(ans.contains(cu)){
                ans.remove(s.charAt(left));
                left++;
            }
            ans.add(cu);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
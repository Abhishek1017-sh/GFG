//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        int n=str.length();
        if (n<7||n>15) return false;
        String[] parts = str.split("\\.");
        if(parts.length!=4) return false;
        for(String part:parts){
            if(part.isEmpty() || part.length()>3) return false;
            if(part.charAt(0)=='0' && part.length()>1) return false;
            for(char ch:part.toCharArray()){
                if(!Character.isDigit(ch)) return false;
            }
            int num;
            try{
                num = Integer.parseInt(part);
            }
            catch(NumberFormatException e){
                return false;
            }
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
}
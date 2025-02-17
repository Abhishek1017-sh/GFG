//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for (int i = 0; i < 81; i++) mat[i / 9][i % 9] = Integer.parseInt(s1[i]);

            Solution obj = new Solution();
            boolean res = obj.isValid(mat);
            if (res)
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
    static boolean isValid(int mat[][]) {
        // code here
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]!=0){
                    if(validr(mat[i][j],i,j,mat) || validc(mat[i][j],i,j,mat) 
                    || validm(mat[i][j],i,j,mat)){
                    return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean validr(int n,int i,int j,int[][] mat){
        for(int c=0;c<9;c++){
            if(mat[c][j]==n && c!=j){
                return true;
            }
        }
        return false;
    }
    static boolean validc(int n,int i,int j,int[][] mat){
        for(int c=0;c<9;c++){
            if(mat[i][c]==n && c!=i){
                return true;
            }
        }
        return false;
    }
    static boolean validm(int n,int i, int j, int[][] mat){
        int bsr=3*(i/3);
        int bsc=3*(j/3);
        for(int m=0;m<9;m++){
            int nr=bsr+m/3;
            int nc=bsc+m%3;
            if(mat[nr][nc]==n && nr/3!=i && nc%3!=j){
                return true;
            }
        }
        return false;
    }
}
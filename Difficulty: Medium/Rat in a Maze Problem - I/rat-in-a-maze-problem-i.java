//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        int rows=mat.size();
        int cols=mat.get(0).size();
        int[][] visited=new int[rows][cols];
        helper(0,0,rows-1,cols-1,mat,visited,rows,cols,res,"");
        return res;
    }
    public static void helper(int sr,int sc,int tr,int tc,
    ArrayList<ArrayList<Integer>> mat,int[][] visited,int rows,int cols,ArrayList<String> res,String s){
        if(sr==tr && sc==tc){
            res.add(s);
            return;
        }
        int[] dr={1,0,0,-1};
        int[] dc={0,-1,1,0};
        String[] dir={"D","L","R","U"};
        if(isValid(sr,sc,rows,cols,mat,visited)){
            visited[sr][sc]=1;
            for(int i=0;i<4;i++){
                helper(sr+dr[i],sc+dc[i],tr,tc,mat,visited,rows,cols,res,s+dir[i]);
            }
            visited[sr][sc]=0;
        }
    }
    public static boolean isValid(int sr,int sc,int rows,int cols,
    ArrayList<ArrayList<Integer>> mat,int[][] visited){
        if(sr<rows && sc<cols && sr>=0 && sc>=0 && mat.get(sr).get(sc)==1
        && visited[sr][sc]==0){
            return true;
        }
        return false;
    }
}
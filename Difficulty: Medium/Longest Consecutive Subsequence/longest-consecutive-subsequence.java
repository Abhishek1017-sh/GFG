//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        if(arr.length==0) return 0;
        Arrays.sort(arr);
        int c=1;
        int max=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-1==arr[i-1]){
                c++;
            }
            else if(arr[i]==arr[i-1]){
                continue;
            } 
            else{
                max=Math.max(c,max);
                c=1;
            }
        }
        return Math.max(c,max);
    }
}
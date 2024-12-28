//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] nums) {
        // code here
        int low=0;
        int mid = 0;
        int high =  nums.length-1;
        while(low<=high){
            if( nums[low]==0){
                int temp  = nums[low];
                nums[low] = nums[mid] ;
                nums[mid] = temp;
                low ++;
                mid ++;
            }
            else if( nums[low] == 2){
                int temp  = nums[low];
                nums[low] = nums[high] ;
                nums[high] = temp;
                high --;
            }
            else if( nums[low] ==1){
                low ++;
            }
        }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends
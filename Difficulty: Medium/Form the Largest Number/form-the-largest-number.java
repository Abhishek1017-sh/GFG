//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] numbers = input.split(" ");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }

            Solution ob = new Solution();
            String ans = ob.findLargest(arr);
            System.out.println(ans);
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    String findLargest(int[] arr) {
        // code here
        String[] s = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            s[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        if (s[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String num : s) {
            result.append(num);
        }
        return result.toString();
    }
}
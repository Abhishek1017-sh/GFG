//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s) {
        // Your code here
        ArrayList<Integer> stack = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.add(ch - '0');
            } 
            else {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                if (ch == '+') {
                    stack.add(a + b);
                } 
                else if (ch == '-') {
                    stack.add(a - b);
                } 
                else if (ch == '*') {
                    stack.add(a * b);
                } 
                else if (ch == '/') {
                    stack.add(a / b);
                }
            }
        }
        return stack.get(0);
    }
}
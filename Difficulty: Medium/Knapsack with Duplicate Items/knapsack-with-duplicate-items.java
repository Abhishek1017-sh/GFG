// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[] dp = new int[capacity + 1];
        for (int w = 0; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                if (wt[i] <= w) {
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
                }
            }
        }
        return dp[capacity];
    }
}
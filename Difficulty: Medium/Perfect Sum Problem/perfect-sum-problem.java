class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int sum) {
        // code here
        int mod = 1000000007;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }

        return dp[sum];
    }
}
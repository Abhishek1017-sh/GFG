class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean[][] dp=new boolean[n][sum+1];
        dp[0][0] =  true;
        if(arr[0]<=sum){
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum;j++){
                boolean skip = dp[i-1][j];
                boolean pick = false;
                if(j-arr[i]>=0){
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j] = skip || pick;
            }
        }

        return dp[n-1][sum];
    }
    
}
// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int m=s1.length();
        int n=s2.length();
        int dp[]=new int[n+1];
        int maxLen=0;
        for(int i=1;i<=m;i++){
            int prevdig=0;
            for(int j=1;j<=n;j++){
                int t=dp[j];
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[j]=1+prevdig;
                    maxLen = Math.max(maxLen, dp[j]);
                }
                else{
                    dp[j]=0;
                }
                prevdig=t;
            }
            
        }
        return maxLen;
    }
}
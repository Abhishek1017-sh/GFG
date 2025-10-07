class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[][] dp=new int[val.length+1][W+1];
        return sol(W,val,wt,0,dp);
        
    }
    static int sol(int w,int[] val,int[] wt,int idx,int[][] dp){
        if(idx==wt.length) return 0;
        if(w<=0) return 0;
        if(wt[idx]<=w){
            if(dp[idx][w]!=0) return dp[idx][w];
            int in=sol(w-wt[idx],val,wt,idx+1,dp)+val[idx];
            int ex=sol(w,val,wt,idx+1,dp);
            return dp[idx][w]=Math.max(in,ex);
        }
        else{
            return dp[idx][w]=sol(w,val,wt,idx+1,dp);
        }
    }
}

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int lo=1;
        int hi=stalls[stalls.length-1]-stalls[0];
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(stalls,k,mid)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] stalls,int k,int mid){
        int count=1;
        int lcp=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lcp>=mid){
                count++;
                lcp=stalls[i];
                if(count==k) return true;
            }
            
        }
        return false;
    }
}
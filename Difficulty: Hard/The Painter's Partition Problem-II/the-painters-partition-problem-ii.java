class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int l=1;
        int h=0;
        for(int e:arr){
            h+=e;
        }
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPoss(arr,k,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean isPoss(int[] arr,int k,int mid){
        int painter=1;
        int tot=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid) return false;
            if(tot+arr[i]>mid){
                painter++;
                tot=arr[i];
            }
            else{
                tot+=arr[i];
            }
            
        }
        return painter<=k;
    }
}

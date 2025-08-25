class Solution {
    class Pair{
        int ele;
        int dis;
        public Pair(int ele,int dis){
            this.ele=ele;
            this.dis=dis;
        }
    }
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int arr1[] = new int[k];
        int n = arr.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(a.dis==b.dis)?b.ele-a.ele:a.dis-b.dis);
        for(int num:arr){
            if(num!=x){
                queue.add(new Pair(num,Math.abs(x-num)));
            }
        }
        for(int i=0;i<k ;i++){
            Pair P = queue .poll();
            arr1[i] = P.ele;
        }
        return arr1;
    }
}
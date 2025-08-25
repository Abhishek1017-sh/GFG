class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.addFirst(pq.poll());
        }
        return list;
    }
}

// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int n=pat.length();
        int sum=0;
        for(char i:pat.toCharArray()){
            sum+=(i-96);
        }
        int i=0;
        int j=0;
        int net=0;
        int c=0;
        while(j<txt.length()){
            net+=(txt.charAt(j)-96);
            if(j-i+1==n){
                if(net==sum && isPoss(pat,txt.substring(i, j + 1))) c++;
                net-=(txt.charAt(i)-96);
                i++;
            }
            j++;
        }
        return c;
    }
    static boolean isPoss(String pat,String txt){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<txt.length();i++){
            map.put(txt.charAt(i),map.getOrDefault(txt.charAt(i),0)+1);
        }
        for(int i=0;i<pat.length();i++){
            if(map.containsKey(pat.charAt(i)) &&  map.get(pat.charAt(i))>0){
                int nf=map.get(pat.charAt(i))-1;
                map.put(pat.charAt(i),nf);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
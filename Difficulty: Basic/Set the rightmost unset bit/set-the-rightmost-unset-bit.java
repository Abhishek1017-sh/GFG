// User function Template for Java
class Solution {
    static int setBit(int n) {
        // code here
        String s="";
        while(n!=0){
            s=n%2+""+s;
            n=n/2;
        }
        StringBuilder sb=new StringBuilder(s);
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'1');
                return solve(sb.toString());
            }
        }
        return solve("1"+sb.toString());
    }
    static int solve(String s){
        int a=0;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                ans+=(int)Math.pow(2,a);
            }
            a++;
        }
        return ans;
    }
}
package Programmers;

class Solution_42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        
        int len = number.length();
        int idx = 0;        
        
        while(k>0){
            idx++;
            if(answer.charAt(idx-1)<answer.charAt(idx)){
                answer.deleteCharAt(idx-1);
                k--;
                len--;
                idx=0;
            }else if(idx==len-1){
                answer.delete(len-k,len);
                break;
            } 
        }
        return answer.toString();
    }
}
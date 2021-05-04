package Programmers;

class Solution_67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] phone = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        int[] left = {3,0};
        int[] right = {3,2};
        for(int n:numbers){
            if(n==1||n==4||n==7){
                answer+="L";
                left = phone[n];
            }
            else if(n==3||n==6||n==9){
                answer+="R";
                right = phone[n];
            }
            else{
                int[] temp = phone[n];
                int distLeft = Math.abs(left[0]-temp[0]) + Math.abs(left[1]-temp[1]);
                int distRight = Math.abs(right[0]-temp[0]) + Math.abs(right[1]-temp[1]);
                if(distLeft==distRight){
                    if(hand.equals("right")){
                        answer+="R";
                        right = phone[n];
                    } else {
                        answer+="L";
                        left = phone[n];
                    }
                } else {
                    if(distLeft > distRight){
                        answer+="R";
                        right = phone[n];
                    } else {
                        answer+="L";
                        left = phone[n];
                    }
                }
            }            
        }
        
        return answer;
    }
}

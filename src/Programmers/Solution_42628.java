package Programmers;

import java.util.*;

class Solution_42628 {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch(oper){
                case "I":
                    max.add(num);
                    min.add(num);
                    break;
                case "D":
                    if(num==1 && !max.isEmpty()){
                        int m = max.poll();
                        min.remove(m);
                    } else if(num==-1 && !min.isEmpty()){
                        int n = min.poll();
                        max.remove(n);
                    }
                    break;
            }
        }
        if(!max.isEmpty()&&!min.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        return answer;
    }
}

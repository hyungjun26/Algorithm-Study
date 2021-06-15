package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingK9RRW3-WJT/
public class lesson8_Dominator {
	public int solution(int[] A) {
        if(A.length==0)return -1;
        int dominator = 0;
        int MAX = 1;        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                int temp = map.get(A[i])+1;
                map.put(A[i], temp);
                if(temp>MAX){
                    MAX = temp;
                    dominator = i;
                }
            }else{
                map.put(A[i], 1);
            }
        }
        //System.out.println(MAX + " " + dominator);
        if(A.length/2+1 <= MAX)return dominator;
        return -1;
    }
}

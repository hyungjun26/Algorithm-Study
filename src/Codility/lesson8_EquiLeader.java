package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingDRM3HZ-3E3/
public class lesson8_EquiLeader {
	public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int MAX = 1;
        int NUM = 0;
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                int temp = map.get(A[i])+1;
                map.put(A[i], temp);
                if(temp>MAX){
                    MAX = temp;
                    NUM = A[i];
                }
            }else{
                map.put(A[i], 1);
            }
        }
        //System.out.println(NUM);
        int left = 0;
        int cnt = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]==NUM){
                left++;
                MAX--;
            }
            int len = A.length-(i+1);
            if((i+1)/2+1<=left && len/2+1<=MAX)cnt++;
        }
        return cnt;
    }
}

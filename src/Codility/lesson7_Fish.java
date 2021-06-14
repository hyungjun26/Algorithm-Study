package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingCUECRC-KPP/
public class lesson7_Fish {
	public int solution(int[] A, int[] B) {
        Stack<Integer> up = new Stack<>();
        Stack<Integer> down = new Stack<>();
        for(int i = 0; i < A.length; i++){
            if(B[i]==0){
                if(down.isEmpty())up.push(A[i]);
                else{
                    while(!down.isEmpty()){
                        if(down.peek()>A[i])break;
                        else down.pop();
                    }
                    if(down.isEmpty())up.push(A[i]);
                }
            }else{
                down.push(A[i]);
            }
        }

        return up.size()+down.size();
    }
}

package Codility;

public class lesson3_TapeEquilibrium {
	public int solution(int[] A) {
        int front = 0;
        int rear = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            rear+=A[i];
        }
        
        for(int i = 0; i < A.length-1; i++){
            front += A[i];
            rear -= A[i];
            if(Math.abs(front-rear) < min){
                min = Math.abs(front-rear);                
            }
        }
        return min;
    }
}

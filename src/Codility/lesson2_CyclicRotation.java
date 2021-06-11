package Codility;

public class lesson2_CyclicRotation {
	public int[] solution(int[] A, int K) {
        if(A.length==0)return A;
        int k = K % A.length;
        for(int n = 0; n < k; n++){
            int last = A[A.length-1];
            int current = A[0];
            for(int i = 0; i < A.length; i++){
                int temp = A[i];
                A[i] = current;
                current = temp;
            }
            A[0] = last;
        }
        return A;
    }
}

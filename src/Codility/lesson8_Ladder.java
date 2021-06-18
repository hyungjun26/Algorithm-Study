package Codility;

// RESULT = https://app.codility.com/demo/results/trainingPNNZHV-X4T/
public class lesson8_Ladder {
	public int[] solution(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int L = A.length;
        int[] fibo = new int[L+1];
        int MAX = (int)Math.pow(2,30);
        fibo[1] = 1;        
        for(int i = 2; i < fibo.length; i++){
            if(i==2)fibo[2] = 2;
            else fibo[i] = (fibo[i-1]+fibo[i-2]) % MAX;
        }
        for(int i = 0; i < ans.length; i++){
            ans[i] = fibo[A[i]] % (int)Math.pow(2,B[i]);
        }
        return ans;
    }
}

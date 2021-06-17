package Codility;

// RESULT = https://app.codility.com/demo/results/training3YQ388-2HR/
public class lesson5_CountDiv {
	public int solution(int A, int B, int K) {
        int cnt = 0;
        if(A==0)cnt++;
        if(A>0 && A%K==0)A--;
        A = A/K;
        B = B/K;
        cnt += (B-A);
        return cnt;
    }
}

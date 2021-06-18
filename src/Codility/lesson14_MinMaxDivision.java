package Codility;

// RESULT = https://app.codility.com/demo/results/training98F5Y3-BNS/
public class lesson14_MinMaxDivision {
	public int solution(int K, int M, int[] A) {
        int min = M*A.length;
        int left = 0;
        int right = M*A.length;
        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            int max = 0;
            int cntGroup = 1;
            for(int i = 0; i < A.length; i++){
                if(sum + A[i] > mid){
                    max = Math.max(sum, max);
                    cntGroup++;
                    sum = A[i];
                } else {
                    sum += A[i];
                }
            }
            max = Math.max(sum,max);
            if(cntGroup > K){
                left = mid + 1;
            } else {
                min = Math.min(max, min);
                right = mid - 1;
            }
        }

        return min; 
    }
}

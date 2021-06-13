package Codility;

// RESULT = https://app.codility.com/demo/results/trainingUDR246-4V9/
public class lesson9_MaxProfit {
	public int solution(int[] A) {        
        int profit = 0;
        int max = 0;
        for(int i = A.length-1; i >= 0 ; i--){
            if(A[i] > max){
                max = A[i];
            } else {
                profit = Math.max(profit, max-A[i]);
            }
        }

        return profit;
    }
}

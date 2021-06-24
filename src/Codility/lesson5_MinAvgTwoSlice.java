package Codility;

// RESULT = https://app.codility.com/demo/results/trainingNJ62F5-K7K/
public class lesson5_MinAvgTwoSlice {
	public int solution(int[] A) {
        int start = 0;
        double min = Double.MAX_VALUE;

        for(int i = 0; i < A.length-1; i++){
            double temp = 0;
            if(i+1 < A.length){
                temp = (A[i]+A[i+1])/2.0;
            }
            if(i+2 < A.length){
                temp = (A[i]+A[i+1])/2.0 > (A[i]+A[i+1]+A[i+2])/3.0 ? (A[i]+A[i+1]+A[i+2])/3.0:(A[i]+A[i+1])/2.0;         
            }
            if(temp < min){                
                min = temp;
                start = i;
            }
        }
        
        return start;
    }
}

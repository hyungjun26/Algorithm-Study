package Codility;

// RESULT = https://app.codility.com/demo/results/training9F5GJX-565/
public class lesson90_FloodDepth {
	public int solution(int[] A) {
        int TOP = 0;
        int topIdx = 0;
        for(int i = 0; i < A.length; i++){
            if(TOP < A[i]){
                TOP = A[i];
                topIdx = i;
            }
        }
        int leftHeight = 1;
        int rightHeight = 1;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i <= topIdx; i++){
            // System.out.println(leftHeight);            
            if(leftHeight <= A[i]){
                leftHeight = A[i];                
            } else {
                leftMax = Math.max(leftMax, leftHeight-A[i]);
            }
        }
        for(int i = A.length-1; i >= topIdx; i--){
            if(rightHeight <= A[i]){
                rightHeight = A[i];                
            } else {
                rightMax = Math.max(rightMax, rightHeight-A[i]);
            }
        }
        return Math.max(leftMax,rightMax);
    }
}	

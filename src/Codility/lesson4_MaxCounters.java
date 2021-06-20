package Codility;

// RESULT = https://app.codility.com/demo/results/trainingJRG2KH-RB2/
public class lesson4_MaxCounters {
	public int[] solution(int N, int[] A) {
        int[] res = new int[N];
        int prev = 0;
        int max = 0;
        boolean check = false;
        for(int n : A){
            if(n > N){
                prev = max;
                check = true;
            }else{
                if(res[n-1]<prev)res[n-1]=prev;
                res[n-1]+=1;
                if(res[n-1]>max)max=res[n-1];
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i]<prev)res[i]=prev;
        }
        return res;
    }
}

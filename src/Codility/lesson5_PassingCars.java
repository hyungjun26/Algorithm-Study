package Codility;

// RESULT = https://app.codility.com/demo/results/trainingN54JMC-N55/ 
public class lesson5_PassingCars {
	public int solution(int[] A) {
        int westCnt = 0;
        int res = 0;
        for(int w:A)if(w==1)westCnt++;

        for(int e:A){
            if(e==0){
                res+=westCnt;
            } else {
                westCnt--;
            }
            if(westCnt==0)break;
            if(res>1000000000)return -1;
        }
        return res;
    }
}

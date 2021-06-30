package Codility;

// RESULT = https://app.codility.com/demo/results/training5WDWVA-7CH/
public class lesson3_FrogJmp {
	public int solution(int X, int Y, int D) {
        if(X>=Y)return 0;
        int cnt = (Y-X)/D;
        int comp = Y-X;
        if(cnt*D > comp){
            while(true){                
                if(D*(cnt-1)>comp){
                    cnt--;
                } else {
                    break;
                }
            }
        } else if(cnt*D < comp){
            while(true){
                cnt++;
                if(D*cnt>=comp){
                    break;
                }
            }
        }
        return cnt;
    }
}

package Programmers;

public class Solution_62048 {
	public long solution(long w, long h) {
        long answer = w * h;
        long sum = w + h;
        long gcd = GCD(w, h);
        return answer-(sum-gcd);
    }
    
    private long GCD(long a, long b){
        if(b==0){
            return a;
        }
        
        return GCD(b, a%b);
    }
}

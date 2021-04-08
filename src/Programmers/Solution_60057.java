package Programmers;

class Solution_60057 {
    public int solution(String s) {
        if(s.length()==1) return 1;
        int answer = 1000;
        for (int i = 1; i <= s.length()/2; i++) {
        	String result = "";
        	String[] arr = new String[1001];
        	int idx = 0;
        	for (int j = 0; j < s.length(); j+=i) {
				if(j + i > s.length()) {
					arr[idx] = s.substring(j);
					idx++;
				} else {
					arr[idx] = s.substring(j, j+i);
					idx++;
				}
			}
        	int cnt = 1;
        	String comp = arr[0];
        	for (int j = 1; j < idx; j++) {
				if(comp.equals(arr[j])) {
					cnt++;
				} else if(cnt == 1) {					
					result += comp;
					comp = arr[j];
					cnt = 1;
				} else {
					result += cnt;
					result += comp;
					comp = arr[j];
					cnt = 1;
				}
				if(j==idx-1) {
					if(cnt == 1)result += comp;
					else result += cnt + comp;
				} 
			}
			if(answer > result.length())answer = result.length();
		}
        return answer;
    }
}
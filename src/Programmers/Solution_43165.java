package Programmers;

class Solution_43165 {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, numbers.length, target, numbers, 0);
        return answer;
    }
    
    private void dfs(int index, int end, int target, int[] numbers, int summary) {
		if(index == end && summary == target) {
			answer++;
			return;
		} else if(index == end && summary != target) {
			return;
		}
		dfs(index+1, end, target, numbers, summary + numbers[index]);      
        dfs(index+1, end, target, numbers, summary - numbers[index]);		
	}
}
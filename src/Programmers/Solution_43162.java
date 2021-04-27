package Programmers;

class Solution_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(computers[i][j]==1&&!visited[i][j]) {
					visited[i][j] = true;
					answer++;
					connectNetwork(i, computers, visited);
				}
			}
		}
        return answer;
    }
    private void connectNetwork(int idx, int[][] computers, boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			if(computers[idx][i]==1 && !visited[idx][i]) {
				visited[idx][i] = true;
				connectNetwork(i, computers, visited);
			}
		}		
	}
}
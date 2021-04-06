package Programmers;

class Solution_60059 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length;
        int N = lock.length;
        int dig = 0;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(lock[i][j]==0)dig++;
			}
		}
        
        // 90도 회전 3회
        outer:for (int rotate = 0; rotate < 4; rotate++) {
        	int[][] keypad = new int[2*N+M][2*N+M];
        	for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					switch (rotate) {
					case 0: // 회전x
						keypad[i+N][j+N] = key[i][j];
						break;
					case 1: // 90도 회전
						keypad[i+N][j+N] = key[M-1-j][i];
						break;
					case 2: // 180도 회전
						keypad[i+N][j+N] = key[M-1-i][M-1-j];
						break;
					case 3: // 270도 회전
						keypad[i+N][j+N] = key[j][M-1-i];
						break;
					}
				}				
			}
        	//우상
        	for (int i = 0; i < M; i++) {
        		for (int j = 0; j < N; j++) {
        			int check = 0;
        			int wrong = 0;
        			int row = N+i;
        			int col = N-j;
        			int r = 0,c = 0;
        			for (int k = row; k < row+N; k++) {
						for (int p = col; p < col+N; p++) {
							if(keypad[k][p]==1 && lock[r][c]==0)check++;
							else if(keypad[k][p]==1 && lock[r][c]==1)wrong++;
							c++;
						}
						r++;
						c = 0;
						if(check == dig && wrong == 0) {
							answer=true;
							break outer;
						}
					}
				}
        	}
        	//좌상
        	for (int i = 0; i < M; i++) {
        		for (int j = 0; j < M; j++) {
        			int check = 0;
        			int wrong = 0;
        			int row = N+i;
        			int col = N+j;
        			int r = 0,c = 0;
        			for (int k = row; k < row+N; k++) {
						for (int p = col; p < col+N; p++) {
							if(keypad[k][p]==1 && lock[r][c]==0)check++;
							else if(keypad[k][p]==1 && lock[r][c]==1)wrong++;
							c++;
						}
						r++;
						c = 0;
						if(check == dig && wrong == 0) {
							answer=true;
							break outer;
						}
					}
				}
        	}
        	//우하
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			int check = 0;
        			int wrong = 0;
        			int row = N-i;
        			int col = N-j;
        			int r = 0,c = 0;
        			for (int k = row; k < row+N; k++) {
						for (int p = col; p < col+N; p++) {
							if(keypad[k][p]==1 && lock[r][c]==0)check++;
							else if(keypad[k][p]==1 && lock[r][c]==1)wrong++;
							c++;
						}
						r++;
						c = 0;
						if(check == dig && wrong == 0) {
							answer=true;
							break outer;
						}
					}
				}
        	}
        	//좌하
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			int check = 0;
        			int wrong = 0;
        			int row = N-i;
        			int col = N+j;
        			int r = 0,c = 0;
        			for (int k = row; k < row+N; k++) {
						for (int p = col; p < col+N; p++) {
							if(keypad[k][p]==1 && lock[r][c]==0)check++;
							else if(keypad[k][p]==1 && lock[r][c]==1)wrong++;
							c++;
						}
						r++;
						c = 0;
						if(check == dig && wrong == 0) {
							answer=true;
							break outer;
						}
					}
				}
        	}
		}
        return answer;
    }
}

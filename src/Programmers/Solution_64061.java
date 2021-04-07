package Programmers;

import java.util.Stack;

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
			int oper = moves[i]-1;
			int doll;
			for (int j = 0; j < board.length; j++) {
				if(board[j][oper] > 0) {
					doll = board[j][oper];
					board[j][oper] = 0;
					if(basket.size()>0&&basket.peek()==doll) {
						basket.pop();
						answer+=2;
					}
					else basket.push(doll);
					break;
				}				
			}
		}
        return answer;
    }
}
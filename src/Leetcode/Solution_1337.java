package Leetcode;

import java.util.PriorityQueue;

public class Solution_1337 {
	class Row implements Comparable<Row>{
		int row;
		int weak;
        Row(int r, int w){
            this.row = r;
            this.weak = w;
        }
		@Override
		public int compareTo(Row r) {
			if(this.weak>r.weak )return 1;
			else if(this.weak==r.weak) {
				if(this.row>r.row)return 1;
			}
			return -1;
		}
	}
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0; i < mat.length; i++){
            boolean check = false;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j]==0){
                    pq.add(new Row(i,j));
                    check = true;
                    break;
                }
            }
            if(!check)pq.add(new Row(i,mat[i].length));
        }
        for(int n = 0; n < ans.length; n++){
            ans[n] = pq.poll().row;
        }
        return ans;
    }
}

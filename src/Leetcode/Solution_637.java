package Leetcode;

import java.util.*;

public class Solution_637 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> average = new ArrayList<>();
        if(root==null)return average;        
        int levelCnt = 1;
        int nextCnt = 0;
        int cnt = 0;
        double sum = 0.0;
        queue.add(root);
        while(true){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                nextCnt++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextCnt++;
            }
            sum += node.val;
            cnt++;
            if(levelCnt==cnt){
                average.add(sum/levelCnt);
                levelCnt = nextCnt;
                nextCnt = 0;
                cnt = 0;
                sum = 0.0;
            }
            if(queue.isEmpty())break;
        }
        return average;
    }
}

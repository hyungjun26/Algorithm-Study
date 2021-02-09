package Leetcode;

import java.util.*;


public class Solution_102 {
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
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        queue.add(root);
        int current = 1;
        int next = current * 2;
        int nullCnt = 0;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            current--;
            if(node.left==null){
                nullCnt++;
            } else {
                queue.add(node.left);
            }
            if(node.right==null){
                nullCnt++;
            } else {
                queue.add(node.right);
            }
            list.add(node.val);
            if(current==0){
                ans.add(list);
                list = new ArrayList<>();
                current = next-nullCnt;
                next = current * 2;
                nullCnt = 0;
            }
        }
        return ans;
    }
}

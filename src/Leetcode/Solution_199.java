package Leetcode;

import java.util.*;

class Solution_199 {
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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if (root != null)
			que.add(root);
		while (!que.isEmpty()) {
			int size = que.size();
			while (size > 0) {
				TreeNode pin = que.poll();
				if (size == 1) {
					ans.add(pin.val);
				}
				if (pin.left != null) {
					que.add(pin.left);
				}
				if (pin.right != null) {
					que.add(pin.right);
				}
				size--;
			}
		}
		return ans;
	}
}

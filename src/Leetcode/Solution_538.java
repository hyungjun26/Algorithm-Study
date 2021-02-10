package Leetcode;

import Leetcode.Solution_102.TreeNode;

public class Solution_538 {
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
	Integer sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)return root;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
    /*
     * public TreeNode convertBST(TreeNode root) {
        if(root==null)return root;
        TreeNode top = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(top);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            list.add(p.val);
            if(p.left!=null)queue.add(p.left);
            if(p.right!=null)queue.add(p.right);
        }
        top = root;
        queue.add(top);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();            
            int sum = 0;
            for(Integer n : list){
                if(p.val < n)sum += n;
            }
            p.val += sum;
            if(p.left!=null)queue.add(p.left);
            if(p.right!=null)queue.add(p.right);
        }
        return root;
    }*/
}

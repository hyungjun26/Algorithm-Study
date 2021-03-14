package Leetcode;

import java.util.*;

public class Solution_1721 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode swapNodes(ListNode head, int k) {
		ListNode temp = head;
		List<ListNode> nodes = new ArrayList<>();
		while (temp != null) {
			nodes.add(temp);
			temp = temp.next;
		}
		ListNode A = nodes.get(k - 1);
		ListNode B = nodes.get(nodes.size() - k);
		int val = A.val;
		A.val = B.val;
		B.val = val;
		return head;
	}
}

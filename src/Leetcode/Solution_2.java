package Leetcode;



public class Solution_2 {
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int up = 0;
		ListNode current = current = new ListNode();
		ListNode ans = current;
		int idx = 0;
		while (l1 != null || l2 != null || up != 0) {
			int a = 0, b = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			int sum = a + b + up;
			up = sum / 10;
			current.val = sum % 10;

			if (l1 != null || l2 != null || up != 0) {
				current.next = new ListNode();
			}
			current = current.next;
		}
		return ans;
	}
}

package Leetcode;

import java.util.HashMap;

public class Solution_138 {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	public Node copyRandomList(Node head) {
        HashMap<Node, Node> list = new HashMap<>();
        Node h = head;
        while(h!=null){
            Node temp = new Node(h.val);
            list.put(h, temp);
            h = h.next;
        }
        for(Node n : list.keySet()){
            list.get(n).next = list.get(n.next);
            list.get(n).random = list.get(n.random);
        }
        return list.get(head);
    }
}

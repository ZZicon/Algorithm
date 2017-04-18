package ตฺถþีย;

public class Lab2_18 {
	public Node insertCirclr(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while (cur != head) {
			if (pre.value <= num && cur.value >= num) {
				break;
			}
			pre.next = node;
			node.next = cur;
			return head.value < num ? head : node;
		}
		return head;
	}
}

package ตฺถþีย;

public class Lab2_4 {
	public Node reverseList(Node head) {
		if (head.next == null) {
			return head;
		}
		Node next = null, pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public DoubleNode reverseLists(DoubleNode head) {
		if (head.next == null) {
			return head;
		}
		DoubleNode pre = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
}

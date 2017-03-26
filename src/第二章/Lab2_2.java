package ตฺถþีย;

class DoubleNode {
	public int value;
	public DoubleNode next;
	public DoubleNode last;
	
	public DoubleNode(int data) {
		this.value = data;
	}
}

public class Lab2_2 {
	public Node removeLastNode(Node head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		Node fast = head;
		Node slow = head;
		if (fast.next == null) {
			head = head.next;
		}
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	public DoubleNode removeLastNode(DoubleNode head, int n){
		if (head == null || n < 1) {
			return head;
		}
		DoubleNode fast = head;
		DoubleNode slow = head;
		if (fast.next == null) {
			head = head.next;
			head.last = null;
		}
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		if(slow.next!=null){
			slow.next.last=slow;
		}
		return head;
	}
}

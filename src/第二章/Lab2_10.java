package ตฺถþีย;

import java.util.Stack;

public class Lab2_10 {
	public Node addListNode(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		int flag = 0;
		Stack <Node> stack1 = new Stack <Node>();
		Stack <Node> stack2 = new Stack <Node>();
		while (head1 != null) {
			stack1.push(head1);
			head1 = head1.next;
		}
		while (head2 != null) {
			stack2.push(head2);
			head2 = head2.next;
		}

		Node add = null;
		Node pre = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int s1 = stack1.isEmpty() ? 0 : stack1.pop().value;
			int s2 = stack2.isEmpty() ? 0 : stack2.pop().value;
			int sum = s1 + s2 + flag;
			int value = sum % 10;
			flag = sum / 10;
			pre = add;
			add = new Node(value);
			add.next = pre;
		}
		if (flag == 1) {
			pre = add;
			add = new Node(1);
			add.next = pre;
		}
		return add;
	}
}

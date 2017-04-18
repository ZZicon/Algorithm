package �ڶ���;

import java.util.Stack;

public class Lab2_12 {

	public Node reversrKNode(Node head, int K) {
		if (head == null || K < 2) {
			return head;
		}
		Stack <Node> stack = new Stack <Node>();
		Node newHead = head;
		Node cur = head;
		Node pre = null, next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == K) {
				// �������
				pre = reset(stack, pre, next);
				// ����ͷ���
				newHead = newHead == head ? cur : newHead;
			}
			cur = cur.next;
		}
		return newHead;
	}

	public Node reset(Stack <Node> stack, Node pre, Node next) {
		Node cur = stack.pop();
		if (pre != null) {
			pre.next = cur;
		}
		Node nextNode = null;
		while (!stack.isEmpty()) {
			nextNode = stack.pop();
			cur.next = nextNode;
			cur = nextNode;
		}
		cur.next = next;
		return cur;
	}
}

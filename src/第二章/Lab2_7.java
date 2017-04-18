package 第二章;

import java.util.Stack;

public class Lab2_7 {
	// 一般解法
	public boolean isPalindromNormal(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack <Node> stack = new Stack <Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// 进阶解法
	public boolean isPalindromUp(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack <Node> stack = new Stack <Node>();
		Node cur = head;
		Node right = head.next;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		int n = 0;
		return true;
	}

	// 空间复杂度最小的解
	public boolean isPalindromComplex(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		// 保存结果
		boolean result = true;

		// 获取中间节点mid
		Node mid = head, node1 = head;
		while (node1.next != null && node1.next.next != null) {
			mid = mid.next;
			node1 = node1.next.next;
		}

		// 右半区逆序
		node1 = mid.next; // 右半区第一个节点
		mid.next = null; // 中间节点指向null
		Node next = null;
		while (node1 != null) {
			next = node1.next;
			node1.next = mid;
			mid = node1;
			node1 = next;
		}

		// 左右进行比较
		Node lnode = head;
		Node rnode = mid;
		while (lnode != null && rnode != null) {
			if (lnode.value != rnode.value) {
				result = false;
			}
			lnode = lnode.next;
			rnode = rnode.next;
		}

		// 恢复
		node1 = mid.next;
		mid.next = null;// 最后一个节点指向null
		while (node1 != null) {
			next = node1.next;
			node1.next = mid;
			mid = node1;
			node1 = next;
		}

		return result;
	}
	
	//常见解法
	public boolean isPalindromEasy(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node cur = head;
		Stack <Node> stack = new Stack <Node>();
		int n = 0;
		while (cur != null) {
			n++;
			cur = cur.next;
		}
		int mid = n / 2;
		while (mid != 0) {
			stack.push(head);
			head = head.next;
			mid--;
		}
		if (n % 2 == 1) {
			head = head.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

}

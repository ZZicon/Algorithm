package 第二章;

import java.util.LinkedList;
import java.util.Queue;

class Node1 {
	public int value;
	public Node1 left;
	public Node1 right;

	public Node1(int data) {
		this.value = data;
	}
}

public class Lab2_15 {

	// 中序遍历
	public void inOrderToQueue(Node1 head, Queue <Node1> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

	public Node1 exchange(Node1 head) {
		Queue <Node1> queue = new LinkedList <Node1>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node1 pre = head;
		pre.left = null;
		Node1 cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}
}

package 第二章;

public class Lab2_11 {

	// 无环链表是否相交
	public Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int s = 0;
		Node cur1 = head1, cur2 = head2;
		while (cur1.next != null) {
			s++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			s--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		if (s > 0) {
			cur1 = head1;
			cur2 = head2;
		} else {
			cur1 = head2;
			cur2 = head1;
		}
		s = Math.abs(s);
		while (s != 0) {
			s--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	// 返回成环链表的入环节点
	public Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node node1 = head.next;
		Node node2 = head.next.next;
		while (node1 != node2) {
			if (node2.next == null || node2.next.next == null) {
				return null;
			}
			node2 = node2.next.next;
			node1 = node1.next;
		}
		node2 = head;
		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

	// 有环链表是否相交
	public Node bothLoop(Node head1, Node head2) {
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		Node cur1 = null, cur2 = null;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, head2);
		}
		return null;
	}
}

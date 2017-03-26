package 第二章;

public class Lab2_5 {
	public Node reversePart(Node head, int from, int to) {
		int n = 0;
		Node cur = head, fnode = null, tnode = null;
		// 链表长度n，from的前一个节点fnode，to的后一个节点tnode
		while (cur != null) {
			n++;
			if (n == from - 1) {
				fnode = cur;
			}
			if (n == to + 1) {
				tnode = cur;
			}
			cur = cur.next;
		}
		if (from > to || from < 1 || to > n) {
			return head;
		}
		if (fnode == null) {
			cur = head;
		} else {
			cur = fnode.next;
		}
		Node cur2 = cur.next;
		// from节点连接tnode
		cur.next = tnode;
		Node next = null;
		while (cur2 != tnode) {
			next = cur2.next;
			cur2.next = cur;
			cur = cur2;
			cur2 = next;

		}
		if (fnode != null) {
			fnode.next = cur;
			return head;
		}
		return cur;
	}
}

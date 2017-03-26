package µÚ¶þÕÂ;

public class Lab2_9 {
	public Node copyListNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node cur = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}

		cur = head;
		Node copy = null;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			if (cur.random.next == null) {
				copy.random = null;
			} else {
				copy.random = cur.random.next;
			}
		}

		// ·ÖÀë
		cur = head;
		Node res = head.next;
		while (cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}
}

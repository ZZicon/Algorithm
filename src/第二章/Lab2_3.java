package �ڶ���;

public class Lab2_3 {
	public Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public Node removeNumNode(Node head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}
		int n = 0;
		Node cur = head;
		// ���������
		while (cur != null) {
			n++;
			cur = cur.next;
		}
		n = (int) Math.ceil(((double) (a * n)) / (double) b);
		if (n == 1) {
			head = head.next;
		}
		if (n > 1) {
			cur = head;
			// Ѱ��Ҫɾ���ڵ��ǰһ���ڵ�
			while (--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
}

package 第二章;

public class Lab2_14 {
	public Node removeValue(Node head, int num) {
		if (head == null || num < 1) {
			return head;
		}

		// 获取第一个非num节点
		while (head != null) {
			if (head.value == num) {
				head = head.next;
			} else {
				break;
			}
		}

		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}

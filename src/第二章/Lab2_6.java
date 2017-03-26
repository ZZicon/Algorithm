package �ڶ���;

public class Lab2_6 {
	// ��ͨ�ⷨ
	public Node josephusNormal(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		int kill = 0;
		// �õ�ͷ�ڵ��ǰһ���ڵ�
		while (last.next != head) {
			last = last.next;
		}
		while (last != head) {
			if (++kill == m) {
				last.next = head.next;
				kill = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	// ���׽ⷨ
	public Node josephusUp(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int key = 1;
		// ��ȡ������
		while (cur != head) {
			key++;
			cur = cur.next;
		}
		key = getLive(key, m);
		while (--key != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	// �ݹ��������ĺ���
	public int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}
}

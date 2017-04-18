package 第二章;

public class Lab2_16 {

	// 查找最小节点前一个节点
	public Node getSmallNode(Node head) {
		Node smallNode = null, small = head;
		Node pre = head, cur = head.next;
		while (cur != null) {
			if (small.value > cur.value) {
				smallNode = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallNode;
	}

	// 排序
	public Node selectionSort(Node head) {
		Node cur = head;
		Node sort = null, small = null, smallPre = null;
		while (cur != null) {
			smallPre = getSmallNode(cur);
			if (smallPre == null) {
				small = cur;
				cur = cur.next;

			} else {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			if (sort == null) {
				head = small;
			} else {
				sort.next = small;
			}
			sort = small;
		}
		return head;
	}
}

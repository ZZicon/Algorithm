package 第二章;

import java.util.HashSet;

public class Lab2_13 {
	// 方法一：遍历删除
	public void removeRep1(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node pre = null, next = null;
		while (cur != null) {
			pre = cur;
			next = cur.next;
			while (next != null) {
				if (cur.value == next.value) {
					pre.next = next.next;
				} else {
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}

	// 方法二：哈希表方法
	public void removeRep2(Node head) {
		if (head == null) {
			return;
		}
		HashSet <Integer> hash = new HashSet <Integer>();
		Node pre = head;
		Node cur = head.next;
		hash.add(head.value);
		while (cur != null) {
			if (hash.contains(cur.value)) {
				pre.next = cur.next;
			} else {
				hash.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}
}

package 第二章;

public class Lab2_8 {
	public Node nodeSort(Node head, int num) {
		if (head == null || head.next == null || num < 1) {
			return head;
		}
		Node lStart = null, lLast = null;
		Node mStart = null, mLast = null;
		Node rStart = null, rLast = null;

		// 分割
		while (head != null) {
			if (head.value < num) {
				if (lStart == null) {
					lStart = head;
					lLast = head;
				} else {
					lLast.next = head;
					lLast = head;
				}
			} else if (head.value == num) {
				if (mStart == null) {
					mStart = head;
					mLast = head;
				} else {
					mLast.next = head;
					mLast = head;
				}
			} else {
				if (rStart == null) {
					rStart = head;
					rLast = head;
				} else {
					rLast.next = head;
					rLast = head;
				}
			}
		}

		// 重连
		if (lStart != null) {
			lLast.next = mStart;
			mLast = mLast == null ? lLast : mLast;
		}
		if (mLast != null) {
			mLast.next = rStart;
		}
		return lStart != null ? lStart : mStart != null ? mStart : rStart;
	}
}

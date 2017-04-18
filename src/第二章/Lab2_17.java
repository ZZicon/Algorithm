package 第二章;

public class Lab2_17 {
	public void removeNode(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			System.out.println("无法删除最后一个节点。");
		}
		node.value = next.value;
		node.next = next.next;
	}
}

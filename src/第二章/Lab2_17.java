package �ڶ���;

public class Lab2_17 {
	public void removeNode(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			System.out.println("�޷�ɾ�����һ���ڵ㡣");
		}
		node.value = next.value;
		node.next = next.next;
	}
}

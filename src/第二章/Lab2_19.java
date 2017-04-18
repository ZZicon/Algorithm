package 第二章;

public class Lab2_19 {
	
	//合并
	public Node merge(Node left, Node right){
		Node next = null;
		while(left.next != null){
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
		return left;
	}
	
	public void relocate(Node head){
		
	}
}

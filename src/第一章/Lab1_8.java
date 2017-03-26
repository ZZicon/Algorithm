package 第一章;

import java.util.HashMap;
import java.util.Stack;

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int data) {
		this.value = data;
	}
}

public class Lab1_8 {
	public Node getMaxTree(int[] queue) {
		Node[] arr = new Node[queue.length];
		// 初始化节点数组存储数组元素
		for (int i = 0; i < queue.length; i++) {
			arr[i] = new Node(queue[i]);
		}
		Stack <Node> stack = new Stack <Node>();
		
		// Map保存左右节点联系
		HashMap <Node, Node> lBigMap = new HashMap <Node, Node>();
		HashMap <Node, Node> rBigMap = new HashMap <Node, Node>();
		
		//所有数的左边第一个比它大的数
		for (int i = 0; i < arr.length; i++) {
			Node curNode = arr[i];
			while ((!stack.isEmpty())
					&& stack.peek().value < curNode.value) {
				StackToMap(stack, lBigMap);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()) {
			StackToMap(stack, lBigMap);
		}
		
		//所有数的右边第一个比它大的数
		for (int i = arr.length - 1; i > -1; i--) {
			Node curNode = arr[i];
			while ((!stack.isEmpty())
					&& stack.peek().value < curNode.value) {
				StackToMap(stack, rBigMap);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()) {
			StackToMap(stack, rBigMap);
		}
		Node head = null;
		
		//生成树
		for (int i = 0; i < arr.length; i++) {
			Node curNode = arr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			if (left == null && right == null) {
				head = curNode;
			} else if (left == null) {
				if (right.left == null) {
					right.left = curNode;
				} else {
					right.right = curNode;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = curNode;
				} else {
					left.right = curNode;
				}
			} else {
				Node parent = left.value < right.value ? left
						: right;
				if (parent.left == null) {
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		return head;
	}
	
	private void StackToMap(Stack <Node> stack, HashMap <Node, Node> map) {
		Node node = stack.pop();
		if (!stack.isEmpty()) {
			map.put(node, null);
		} else {
			map.put(node, stack.peek());
		}
	}
}

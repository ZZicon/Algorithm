package TEXT;

import java.util.Stack;

public class Lab1_3 {
	// 获取并移除栈底元素
	public static int getAndRemoveLastElement(Stack <Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	// 逆序的递归操作
	public static void reverse(Stack <Integer> stack) {
		if (stack.isEmpty()) {
			return;
		} else {
			int last = getAndRemoveLastElement(stack);
			reverse(stack);
			stack.push(last);
		}
	}
}

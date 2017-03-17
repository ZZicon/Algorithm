package TEXT;

import java.util.Stack;

public class Lab1_3 {
	// ��ȡ���Ƴ�ջ��Ԫ��
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

	// ����ĵݹ����
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

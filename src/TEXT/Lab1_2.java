package TEXT;

import java.util.Stack;

public class Lab1_2 {
	public Stack <Integer> stackPop;
	public Stack <Integer> stackPush;

	public Lab1_2() {
		stackPop = new Stack <Integer>();
		stackPush = new Stack <Integer>();
	}

	public void add(int newNum) {
		stackPush.push(newNum);
		//������push�����ѹ��stackPop�������һ��ѹ���stackPopΪ��
		if (stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("Your queue is empty");
		} else if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
	}

	public int poll() {
		return stackPush.pop();
	}

	public int peek() {
		return stackPush.peek();
	}

}

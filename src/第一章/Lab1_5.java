package ╣зр╩уб;

import java.util.Stack;

public class Lab1_5 {
	public static void sortStackByStack(Stack <Integer> stack) {
		Stack <Integer> stack2 = new Stack <Integer>();
		while (!stack.isEmpty()) {
			int num = stack.pop();
			while (num > stack2.peek() && !stack2.isEmpty()) {
				stack.push(stack2.pop());
			}
			stack2.push(num);
		}
		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
	}
}

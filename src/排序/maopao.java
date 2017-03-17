package ≈≈–Ú;

public class maopao {
	public static int[] bubbleSort(int[] queue) {
		if (queue == null || queue.length < 2) {
			return queue;
		}
		int temp;
		boolean flag = false;
		for (int i = queue.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (queue[j + 1] < queue[j]) {
					temp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				return queue;
			}
		}
		return queue;
	}

	public static void main(String args[]) {
		int queue[] = { 7, 5, 2, 4, 6, 1, 3 };
		queue = bubbleSort(queue);
		for (int i = 0; i < queue.length; i++)
			System.out.print(queue[i] + "");
	}
}

package еепР;

public class lab {
	public static int[] sort(int[] queue) {
		if (queue == null || queue.length < 2) {
			return queue;
		}
		int key;
		for (int i = 1; i < queue.length; i++) {
			for (int j = i; j > 0; j--) {
				if (queue[j] < queue[j - 1]) {
					key = queue[j];
					queue[j] = queue[j - 1];
					queue[j - 1] = key;
				}
			}
		}
		return queue;
	}

	public static void main(String args[]) {
		int queue[] = { 7, 5, 2, 4, 6, 1, 3 };
		queue = sort(queue);
		for (int i = 0; i < queue.length; i++)
			System.out.print(queue[i] + "");
	}
}

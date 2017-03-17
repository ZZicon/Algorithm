package 排序;

public class chose {
	public static int[] selectSort(int[] queue) {
		int minIndex, temp = 0;
		if (queue == null || queue.length < 2) {
			return queue;
		}
		for (int i = 0; i < queue.length - 1; i++) {
			// 无序区的最小元素的下标
			minIndex = i;
			for (int j = i + 1; j < queue.length; j++) {
				// 寻找最小元素并保存其下标
				if (queue[j] < queue[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 将找到的最小元素与前面数据交换位置
				temp = queue[i];
				queue[i] = queue[minIndex];
				queue[minIndex] = temp;
			}
		}

		return queue;
	}

	public static void main(String args[]) {
		int queue[] = { 7, 5, 2, 4, 6, 1, 3 };
		queue = selectSort(queue);
		for (int i = 0; i < queue.length; i++)
			System.out.print(queue[i]);
	}
}

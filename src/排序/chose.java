package ����;

public class chose {
	public static int[] selectSort(int[] queue) {
		int minIndex, temp = 0;
		if (queue == null || queue.length < 2) {
			return queue;
		}
		for (int i = 0; i < queue.length - 1; i++) {
			// ����������СԪ�ص��±�
			minIndex = i;
			for (int j = i + 1; j < queue.length; j++) {
				// Ѱ����СԪ�ز��������±�
				if (queue[j] < queue[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// ���ҵ�����СԪ����ǰ�����ݽ���λ��
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

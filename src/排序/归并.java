package 排序;

public class 归并 {
	public static void merge(int[] queue, int p, int q, int r) {
		int i = p, j = q, m = q + 1, n = r, k = 0;
		int temp[] = new int[r - p + 1];
		while (i <= j && m <= n) {
			if (queue[i] < queue[m]) {
				temp[k++] = queue[i++];
			} else {
				temp[k++] = queue[m++];
			}
		}
		while (i <= j) {
			temp[k++] = queue[i++];
		}
		while (m <= n) {
			temp[k++] = queue[m++];
		}
		System.arraycopy(temp, 0, queue, p, temp.length);
	}

	public static void mergeSort(int[] queue, int p, int r) {
		if (p > r) {
			int q = (p + r) / 2;
			mergeSort(queue, p, q);
			mergeSort(queue, q + 1, r);
			// 合并两个有序序列
			merge(queue, p, q, r);
		}
	}

	public static void main(String args[]) {
		int queue[] = { 3, 41, 52, 26, 38, 57, 9, 49 };
		mergeSort(queue, 0, 7);
		for (int l = 0; l < queue.length; l++)
			System.out.print(queue[l] + " ");
	}
}

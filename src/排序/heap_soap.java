package 排序;

public class heap_soap {

	// 调整堆
	public static void MaxHeapify(int a[], int size, int i) {
		int left = 2 * i + 1;
		int right = 2 * (i + 1);
		int max = i;
		int temp;
		if (left <= size && a[left] > a[max]) {
			max = left;
		}
		if (right <= size && a[right] > a[max]) {
			max = right;
		}
		if (max != i) {
			temp = a[max];
			a[max] = a[i];
			a[i] = temp;
			// 避免调整之后以max为父节点的子树不是堆
			MaxHeapify(a, size, max);
		}
	}

	// 建立堆
	public static void BuildMaxHeap(int a[], int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			MaxHeapify(a, size - 1, i);
		}
	}

	// 堆排序
	public static void HeapSort(int a[], int size) {
		int temp;
		BuildMaxHeap(a, size);
		for (int i = size - 1; i >= 1; i--) {
			temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			MaxHeapify(a, i - 1, 0);
		}
	}

	public static void main(String args[]) {
		int a[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n排序后");
		HeapSort(a,a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

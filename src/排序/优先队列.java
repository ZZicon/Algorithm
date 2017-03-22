package 排序;

//import java.util.PriorityQueue;

public class 优先队列 {
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

	// 返回最大值
	public static int HeapMaxNum(int a[]) {
		return a[0];
	}

	// 返回并去掉最大值
	public static int[] HeapExtractMax(int a[]) {
		if (a.length < 0) {
			System.out.println("数组为空！");
		}
		int max = a[0];
		a[0] = a[a.length - 1];
		MaxHeapify(a, a.length - 1, 0);
		int[] b = new int[a.length - 1]; 
		return b;
	}

	// 把下标i的值增加
	public static void HeapChangeKey(int a[], int i, int num) {
		int temp;
		if (num < a[i]) {
			System.out.println("new num is smaller than current num!");
		}
		a[i] = num;
		while (i > 1 && a[i / 2] < a[i]) {
			temp = a[i];
			a[i] = a[i / 2];
			a[i / 2] = a[i];
			i = i / 2;
		}
	}

	// 元素插入堆
	public int[] HeapInsert(int a[], int num) {
		int[] b = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		b[a.length] = num;
		HeapChangeKey(b,a.length,num);
		return b;
	}

	public static void main(String args[]) {
		int a[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		int b[];
		BuildMaxHeap(a, a.length);
		b = HeapExtractMax(a);
		for(int i = 0;i<b.length;i++){
			System.out.print(b[i] + " ");
		}
	}
}

package ����;

//import java.util.PriorityQueue;

public class ���ȶ��� {
	// ������
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
			// �������֮����maxΪ���ڵ���������Ƕ�
			MaxHeapify(a, size, max);
		}
	}

	// ������
	public static void BuildMaxHeap(int a[], int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			MaxHeapify(a, size - 1, i);
		}
	}

	// �������ֵ
	public static int HeapMaxNum(int a[]) {
		return a[0];
	}

	// ���ز�ȥ�����ֵ
	public static int[] HeapExtractMax(int a[]) {
		if (a.length < 0) {
			System.out.println("����Ϊ�գ�");
		}
		int max = a[0];
		a[0] = a[a.length - 1];
		MaxHeapify(a, a.length - 1, 0);
		int[] b = new int[a.length - 1]; 
		return b;
	}

	// ���±�i��ֵ����
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

	// Ԫ�ز����
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

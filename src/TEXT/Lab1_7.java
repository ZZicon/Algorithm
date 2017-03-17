package TEXT;

import java.util.LinkedList;

public class Lab1_7 {
	public int getMax(int n1, int n2, int n3) {
		int max = 0;
		if (n1 > n2) {
			max = n1;
		} else {
			max = n2;
		}
		max = (max > n3) ? max : n3;
		return max;
	}

	public int[] function1(int arr[], int w) {
		int answer[] = new int[arr.length + -w + 1];
		for (int i = 0; i < arr.length - w + 1; i++) {
			answer[i] = getMax(arr[i], arr[i + 1], arr[i + 2]);
		}
		return answer;
	}

	public int[] function2(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList <Integer> maxqueue = new LinkedList <Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!maxqueue.isEmpty()
					&& arr[maxqueue.peekLast()] <= arr[i]) {
				maxqueue.pollLast();
			}
			maxqueue.addLast(i);
			if (maxqueue.peekFirst() == i - w) {
				maxqueue.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[maxqueue.peekFirst()];
			}
		}
		return res;
	}
}

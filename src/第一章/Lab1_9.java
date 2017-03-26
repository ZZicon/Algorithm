package 第一章;

import java.util.Stack;

public class Lab1_9 {
	public static int maxRecSize(int[][] map) {
		// map.lehgth是图的高度（行数）;map[0].length是图的宽度（列数）
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int Max = 0;
		int height[] = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			Max = maxNumFromHeight(height) > Max ? maxNumFromHeight(height)
					: Max;
		}
		return Max;
	}

	public static int maxNumInHeight(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int l = 0, num = 0, max = 0;
		for (int i = 0; i < height.length; i++) {
			l = 0;
			num = height[i];
			for (int j = i; j >= 0; j--) {
				if (num <= height[j]) {
					l++;
				} else {
					break;
				}
			}
			for (int k = i + 1; k < height.length; k++) {
				if (num <= height[k]) {
					l++;
				} else {
					break;
				}
			}
			max = Math.max(num * l, max);
		}
		return max;
	}

	public static int maxNumFromHeight(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int MaxArea = 0;
		Stack <Integer> stack = new Stack <Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty()
					&& height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int Area = (i - k - 1) * height[j];
				MaxArea = Math.max(Area, MaxArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int Area = (height.length- k - 1) * height[j];
			MaxArea = Math.max(Area, MaxArea);
		}
		return MaxArea;
	}

	public static void main(String args[]) {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 } };
		int max = maxRecSize(map);
		System.out.println(max);
	}
}

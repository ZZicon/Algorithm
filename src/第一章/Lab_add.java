package ��һ��;

public class Lab_add {

	// һά�����ȡ���ֵ
	public static int maxqueue(int[] queue) {
		if (queue.length == 0) {
			return 0;
		}
		int max = 0;
		int[] maxque = new int[queue.length];
		maxque[0] = queue[0];
		for (int i = 1; i < queue.length; i++) {
			maxque[i] = (maxque[i - 1] > 0) ? (maxque[i] + queue[i])
					: queue[i];
			if (max < maxque[i]) {
				max = maxque[i];
			}
		}
		return max;
	}

	// �Ѷ�ά���齵Ϊһά
	public static int[][] down(int[][] map) {
		int[][] res = map;
		for (int i = 1; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				res[i][j] += res[i - 1][j];
			}
		}
		return res;
	}

	// ��ȡ����Ӿ���
	public static int maxMatrix(int[][] map) {
		int[][] res = down(map);
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = i; j < map.length; j++) {
				int[] result = new int[map[0].length];
				for (int k = 0; k < map[0].length; k++) {
					if (i == 0) {
						result[k] = res[j][k];
					} else {
						result[k] = res[j][k] - res[i - 1][k];
					}
				}
				max = maxqueue(result) > max ? maxqueue(result) : max;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		int map[][] = { { 9, 2, -6, 2 }, { -4, 1, -4, 1 },
				{ -1, 8, 0, -2 } };
		int max = maxMatrix(map);
		System.out.println(max);
	}
}

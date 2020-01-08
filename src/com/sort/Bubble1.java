package com.sort;

import java.util.Arrays;

public class Bubble1 {
	public static void main(String[] args) {
		int[] arr = { 14, 9, 8, 42, 5, 7, 6 };
		int[] arr_ = sort2(arr);
		System.out.println(Arrays.toString(arr_));
	}

	/**
	 * 最终结果要是 1,2,3,4,5这个样子
	 * 
	 * @param arr
	 */
	private static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int tmp = 0;
			if (arr[i] > arr[i + 1]) {
				// 取出小的
				tmp = arr[i + 1];
				// 交换
				arr[i + 1] = arr[i];
				arr[i] = tmp;
			}
		}
		return arr;
	}

	private static int[] sort2(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				int tmp = 0;
				if (arr[i] > arr[i + 1]) {
					// 取出小的
					tmp = arr[i + 1];
					// 交换
					arr[i + 1] = arr[i];
					arr[i] = tmp;
				}
			}
			System.out.println(j + "次," + Arrays.toString(arr));
		}
		return arr;
	}
}

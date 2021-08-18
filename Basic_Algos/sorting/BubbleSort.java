
/**
 * Bubble Sort
 * In this, adjacent elements are compared and swapped if they are not in right order.
 * 
 * output : 
 * Sorted array : [2, 3, 3, 5, 5, 6]
 * 
 */

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 2, 3, 5 };
		int length = arr.length;

		for (int i = 0; i < length; ++i) {
			for (int j = 1; j < length - i; ++j) {
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		System.out.println("Sorted array : " + Arrays.toString(arr));
	}

}

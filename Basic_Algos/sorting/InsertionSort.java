
/**
 * Insertion Sort
 * It is a simple sorting algorithm that works the way we sort playing cards in our hand.
 * In this, we take an element, traverse to the left part of the array, and find its correct position.
 * 
 * Output : 
 * After soring : [3, 3, 5, 5, 6, 23, 76]
 */

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 5, 6, 3, 76, 3, 23, 5 };
		int length = arr.length;

		for (int i = 1; i < length; ++i) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				--j;
			}
		}

		System.out.println("After soring : " + Arrays.toString(arr));

	}

}


/**
 * Selection sort
 * 
 * In selection sort, we find minimum element in unsorted part of the array and swap it with the first element.
 * 
 * Output : 
 * Sorted array : [1, 3, 6, 6, 6, 7, 23, 23, 62, 76, 234, 345, 345, 534]
 * 
 */

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 3, 534, 6, 23, 6, 234, 345, 6, 23, 345, 62, 76, 7, 1 };
		int length = arr.length;
		for (int i = 0; i < length; ++i) {
			int min = i;
			for (int j = i + 1; j < length; ++j) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}

}

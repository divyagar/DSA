import java.util.Arrays;

public class heap_sort {
	private static int[] arr = { 2, 34, 53, 32, 543, 665, 23, 4, 3, 6 };
	private static int len = arr.length;

	private static void heapify(int i, int len) {
		int largest = i;
		int left = 2 * i + 1, right = 2 * i + 2;

		if (left < len && arr[left] > arr[largest])
			largest = left;
		if (right < len && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;

			heapify(largest, len);
		}
	}

	private static void heap_sort() {
		for (int i = 0; i < len; ++i) {
			int tmp = arr[0];
			arr[0] = arr[len - i - 1];
			arr[len - i - 1] = tmp;

			heapify(0, len - i - 1);
		}
	}

	public static void main(String[] args) {
		for (int i = (len / 2) - 1; i >= 0; --i) {
			heapify(i, len);
		}

		System.out.println("Heaped : " + Arrays.toString(arr));
		heap_sort();
		System.out.println("Sorted : " + Arrays.toString(arr));
	}

}

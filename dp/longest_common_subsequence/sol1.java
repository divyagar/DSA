/**
 * sol1 - Recursion
 * 
 * Time complexity : O(2^n)
 * 
 * Output
 * 
 * LIS is : 3
 */
public class sol1 {
	private static int ans = 1;

	private static int findLIS(int[] arr, int n) {
		if (n == 0)
			return 1;

		int res = 1;

		for (int i = 0; i < n; ++i) {
			int r = findLIS(arr, i);
			if (r + 1 > res && arr[i] < arr[n])
				res = r + 1;
		}
		ans = Math.max(ans, res);

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 10, 2, 11 };
		int n = arr.length;

		System.out.println("LIS is : " + findLIS(arr, n - 1));
	}

}
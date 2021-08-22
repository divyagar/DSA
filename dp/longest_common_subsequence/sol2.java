/**
 * Dyanmic programming : Memoization
 * 
 * Time complexity : O(n^2)
 * 
 * Output :
 * 
 * LIS is : 3
 */

public class sol2 {
	private static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int ans[] = new int[n];

		int res = 1;

		for (int i = 0; i < n; ++i) {
			int max = 1;
			for (int j = i - 1; j >= 0; --j) {
				if (nums[i] > nums[j] && ans[j] + 1 > max)
					max = ans[j] + 1;
			}
			ans[i] = max;
			res = Math.max(res, max);
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 10, 2, 11 };
		System.out.println("LIS is : " + lengthOfLIS(arr));

	}

}

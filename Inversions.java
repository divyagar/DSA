// Inversions using merge sort
package Algos;
import java.util.*;
public class Inversions {
	static int[] arr;
	static int count = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		
		mergeSort(0, n-1);
		System.out.println(count);
		
	}
	
	private static void mergeSort(int beg, int end){
		if(beg == end)
			return;
		
		int mid = (beg + end) / 2;
		mergeSort(beg, mid);
		mergeSort(mid+1, end);
		merging(beg, mid, end);
	}
	
	private static void merging(int beg, int mid, int end){
		int size = (end - beg) + 1;
		int[] tempArr = new int[size];
		int i = beg, j = mid+1;
		int index = 0;
		while(i <= mid && j <= end){
			if(arr[i] <= arr[j]){
				tempArr[index] = arr[i];
				index++;
				i++;
			}
			else{
				tempArr[index] = arr[j];
				// if element i is greater than element j that means that element j is smaller than 
				// all the elements ranging from i to mid(as left array is already sorted).
				count += ((mid - i)+1);
				index++;
				j++;
			}
		}
		
		while(i <= mid){
			tempArr[index] = arr[i];
			index++;
			i++;
		}
		while(j <= end){
			tempArr[index] = arr[j];
			index++;
			j++;
		}
		
		for(i = 0; i<size; i++){
			arr[beg + i] = tempArr[i];
		}
	}
	
	
	
	
	
}

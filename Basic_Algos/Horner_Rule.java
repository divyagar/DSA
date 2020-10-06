import java.util.*;
public class Horner_Rule {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = sc.nextInt();
		
		int x = sc.nextInt();
		
		int ans = arr[0];
		int i = 1;
		while(i < n){
			ans *= x;
			ans += arr[i];
			i++;
		}
		
		System.out.println(ans);
	}
}

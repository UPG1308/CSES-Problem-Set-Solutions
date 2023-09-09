// package Introductory_Problems;
import java.util.Scanner;
public class MissingNumber {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n - 1];
		// int num = 0;
		for(int i = 0; i < n - 1; i++){
			arr[i] = sc.nextInt();
		}
		int xor = 0;
		for(int i = 1; i <= n; i++)xor = xor ^ i;
		for(int i = 0; i < n - 1; i++) {
			xor = xor ^ arr[i];
		}
		System.out.println(xor);
	}		
}

// import java.util.Scanner;
// public class missing
// {
	
// }
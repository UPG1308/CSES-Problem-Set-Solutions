import java.util.Scanner;
public class IncreasingArray
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i = 0;i < n; i++)arr[i] = sc.nextInt();
		long count = 0;
		for(int i = 1;i < n; i++){
		  if(arr[i] < arr[i - 1]){
		    long difference = arr[i - 1] - arr[i];
		    count += difference;
		    arr[i] = arr[i] + difference;
		  }
		}
		System.out.println(count);
	}		
}
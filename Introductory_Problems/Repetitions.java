import java.util.Scanner;
public class Repetitions
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length();
		int count = 1, max = 1;
		for(int i = 1; i < n; i++){
		  if(str.charAt(i) == str.charAt(i - 1)){
		    count++;
		    max = Math.max(max , count);
		  }
		  else count = 1;
		}
		System.out.println(max);
		
	}		
}
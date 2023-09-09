package Introductory_Problems;
import java.util.Scanner;
public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(1);
        } else if (n < 4) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder beautifulPermutation = new StringBuilder();

            // Initialize two variables for even and odd numbers
            int even = 2;
            int odd = 1;

            // Append even numbers first
            while (even <= n) {
                beautifulPermutation.append(even).append(" ");
                even += 2;
            }

            // Append odd numbers
            while (odd <= n) {
                beautifulPermutation.append(odd).append(" ");
                odd += 2;
            }

            // Print the beautiful permutation
            System.out.println(beautifulPermutation);
        }
    }
}

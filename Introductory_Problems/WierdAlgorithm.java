package Introductory_Problems;
import java.util.Scanner;
class WierdAlgorithm{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        while(n > 1){
            if(n % 2 == 0){
                System.out.print(n+" ");
                n /=2;
            }
            else{
                System.out.print(n + " ");
                n = n * 3 + 1;
            }
            
        }
        System.out.print(n);
    }
}
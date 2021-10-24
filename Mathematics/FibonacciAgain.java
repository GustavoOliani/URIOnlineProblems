/*
Here is the Problem: https://www.urionlinejudge.com.br/judge/en/problems/view/1531
*/
package Mathematics;
import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        while(reader.hasNextLine()){
            int n = reader.nextInt();
            int m = reader.nextInt();

            // Calculate Fib(n)
            n = CalcularFibonacci(n);

            // Calculate the remainder of Fib(Fib(n)) divided by m
            System.out.println(CalcularFibonacci(n) % m);
        }
        reader.close();
    }

    public static int CalcularFibonacci(int n){

        int fib1 = 1, fib2 = 0, inter = 0;

        for (int i = 1; i < n; i++){
            inter = fib1;
            fib1 += fib2;
            fib2 = inter;
        }
        return fib1;
    }
}

/*
Here is the Problem: https://www.urionlinejudge.com.br/judge/en/problems/view/1531
*/
import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);

        while(reader.hasNextLine()){
            int n = reader.nextInt();
            int m = reader.nextInt();

            // Calculate Fib(n)
            n = CalcularFibonacci(n);

            // Calculate Fib(Fib(n)) and divide by m
            System.out.println(CalcularFibonacci(n)/m);
        }
        reader.close();
    }

    public int CalcularFibonacci(int n){

            int fib1 = 1;
            int fib2 = 0;
            int inter = 0;

            for (int i = 1; i < n; i++){
                inter = fib1;
                fib1 += fib2;
                fib2 = inter;
            }
        return fib1;
    }
}

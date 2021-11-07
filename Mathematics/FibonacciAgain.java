/*
Here is the Problem: https://www.urionlinejudge.com.br/judge/en/problems/view/1531
*/
package Mathematics;
import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        try {
            while(reader.hasNextLine()){
                long n = reader.nextLong(), m = reader.nextLong();
    
                // Calculate Fib(n)
                n = CalcularFibonacci(n);
                System.out.println(n);
                // Calculate the remainder of Fib(Fib(n)) divided by m
                System.out.println(CalcularFibonacci(n));
            }
        } catch (Exception e) {
            reader.close();
        }
    }

    public static long CalcularFibonacci(long n){
        long a[][] = {{1,1},{1,0}};
        a = binaryExp(a, n);
        return a[1][0];
    }

    public static long[][] binaryExp(long[][] base, long expoente){
        long i[][] = {{1 , 1} , {1 , 1}};
        if(expoente == 0) return i;
        else if(expoente == 1) return base;
        else{
            long[][] r = binaryExp(base, expoente/2);
            if(expoente % 2 == 0) {
                return multMatrix2x2(r, r);
            }
            else return multMatrix2x2(base, multMatrix2x2(r, r));
        }
    }
    //Calcula A*B, onde A e B são matrizes 2x2
    private static long[][] multMatrix2x2(long[][] a, long[][] b){
        return new long[][]{{a[0][0] * b[0][0] + a[0][1] * b[1][0],
                            a[0][0] * b[0][1] + a[0][1] * b[1][1]},
                            {a[1][0] * b[0][0] + a[1][1] * b[1][0],
                            a[1][0] * b[0][1] + a[1][1] * b[1][1]}};
    }
}
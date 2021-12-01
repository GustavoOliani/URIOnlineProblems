package Paradigms;

/*
 Here is the Problem: https://www.beecrowd.com.br/judge/en/problems/view/1029

Test cases:
! fib(5) = 14 calls = 5              
! fib(4) = 8 calls = 3               
! fib(3) = 4 calls = 2               
! fib(8) = 66 calls = 21             
! fib(35) = 29860702 calls = 9227465  
! fib(30) = 2692536 calls = 832040    
*/

import java.math.*;
import java.util.*;

public class FibonacciHowManyCalls{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        final int numberOftests = reader.nextInt();
        for(int i = 0; i < numberOftests; i ++){
            final BigInteger fibonacciTerm = reader.nextBigInteger();
            BigInteger fibNumber = CalcularFibonacci(fibonacciTerm);            
            System.out.println("fib(" + fibonacciTerm + ") = " + NumberOfRecursiveCalls(fibonacciTerm) + " calls = " +
            fibNumber);
        }
        reader.close();
    }

    public static long NumberOfRecursiveCalls(BigInteger fibonacciTerm){
        long n1 = 0, n2 = 0, temp = 0;
        
        for(long i = 2; fibonacciTerm.compareTo(BigInteger.valueOf(i)) >= 0; i++){
            temp = n1;
            n1 += n2 + 2;
            n2 = temp;
        }
        return n1;
        
    }

    public static BigInteger CalcularFibonacci(BigInteger n){
        final BigInteger one = BigInteger.ONE;
        BigInteger a[][] = {{one,one},{one,BigInteger.ZERO}};
        a = binaryExp(a, n);
        return a[0][1];
    }


    public static BigInteger[][] binaryExp(BigInteger[][] base, BigInteger expoente){
        final BigInteger one = BigInteger.ONE;
        BigInteger i[][] = {{one , one} , {one , one}};
        if(expoente.compareTo(BigInteger.ZERO) == 0) return i;
        else if(expoente.compareTo(one) == 0) return base;
        else{
            BigInteger[][] r = binaryExp(base, expoente.divide(BigInteger.valueOf(2)));
            if(expoente.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
                return multMatrix2x2(r, r);
            }
            else return multMatrix2x2(multMatrix2x2(r, r), base);
        }
    }
    
    //Calcula A*B, onde A e B são matrizes 2x2
    private static BigInteger[][] multMatrix2x2(BigInteger[][] a, BigInteger[][] b){
        return new BigInteger[][]{{
            a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])),
            
            a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                            
            {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])),
            
            a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))}};
    }

}
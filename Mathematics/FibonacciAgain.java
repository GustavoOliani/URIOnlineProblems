/*
Here is the problem: https://www.beecrowd.com.br/judge/en/problems/view/1531?origem=1

Tests case:
! 1         | 2
! 2         | 2
! 3         | 2
! 4         | 2
! 5         | 2
! 967870170 | 2
! 105705    | 993847
! 976092081 | 1382
! 119718    | 1771
! 911107604 | 50
! 130333    | 250
! 975484441 | 978799
! 112316    | 31250
! 109040    | 1250
! 906948181 | 8
*/

package Mathematics;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        try {
            while(reader.hasNextLine()){
                // 1 ≤ N ≤ 10^9
                BigInteger n = reader.nextBigInteger();
                // 2 ≤ M ≤ 10^6
                BigInteger m = reader.nextBigInteger();
    
                // Calculate Fib(n)
                BigInteger answer = CalcularFibonacci(n);

                // Calculate the remainder of Fib(Fib(n)) divided by m
                System.out.println(CalcularFibonacci(answer).remainder(m));
            }
        } catch (Exception ex) {
            reader.close();
        }
    }

    public static BigInteger CalcularFibonacci(BigInteger n){
        final BigInteger one = BigInteger.ONE;
        BigInteger a[][] = {{one,one},{one,BigInteger.ZERO}};
        a = binaryExponentiation(a, n);
        return a[0][1];
    }

    public static BigInteger[][] binaryExponentiation(BigInteger[][] base, BigInteger expoente){
        final BigInteger one = BigInteger.ONE;
        BigInteger i[][] = {{one , one} , {one , one}};
        if(expoente.compareTo(BigInteger.ZERO) == 0) return i;
        else if(expoente.compareTo(one) == 0) return base;
        else{
            BigInteger[][] partialResult = binaryExponentiation(base, expoente.divide(BigInteger.valueOf(2)));
            if(expoente.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
                return multMatrix2x2(partialResult, partialResult);
            }
            else return multMatrix2x2(multMatrix2x2(partialResult, partialResult), base);
        }
    }
    
    //Calculate A*B, where A and B are 2x2 matrix
    private static BigInteger[][] multMatrix2x2(BigInteger[][] a, BigInteger[][] b){
        return new BigInteger[][]{{
            a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])),
            
            a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                            
            {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])),
            
            a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))}};
    }
}
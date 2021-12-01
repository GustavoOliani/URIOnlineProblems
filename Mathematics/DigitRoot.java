/*
    Here is the problem: https://www.beecrowd.com.br/judge/en/problems/view/2859

    input:
    1 ≤ b ≤ 10^(10^5)
    1 ≤ e ≤ 10^(10^5)
*/

package Mathematics;
import java.math.BigInteger;
import java.util.Scanner;

public class DigitRoot{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long result;
        try {
            final BigInteger b = reader.nextBigInteger();
            final BigInteger e = reader.nextBigInteger();
            final BigInteger multiplied = binaryExponentiation(b, e);
            result = DividindoNumero(multiplied).longValue();
            while (result > 10 && result % 10 != 0){
                result = DividindoNumero(BigInteger.valueOf(result)).longValue();
            }
            if (result % 10 == 0){
                while(result >= 10){
                    result /= 10;
                }
            }
            System.out.println(result);
        } finally {
            reader.close();
        }
    }

    public static BigInteger DividindoNumero(BigInteger number){
        BigInteger remainder = number.remainder(BigInteger.TEN);
        if (remainder.compareTo(BigInteger.ZERO) == 0 || number.compareTo(BigInteger.TEN) == -1)
            return number;
        else {
            return remainder.add(DividindoNumero(number.divide(BigInteger.TEN)));
        }
    }

    public static BigInteger binaryExponentiation(BigInteger base, BigInteger expoente){
        final BigInteger two = BigInteger.valueOf(2);
        if(expoente.equals(BigInteger.ZERO)) return BigInteger.ONE;
        else if(expoente.equals(BigInteger.ONE)) return base;
        else{
            BigInteger r = binaryExponentiation(base, expoente.divide(two));
            if(expoente.mod(two).equals(BigInteger.ZERO)) {
                return r.multiply(r);
            }
            else {
                return r.multiply(r.multiply(base));
            }
        }
    }
}
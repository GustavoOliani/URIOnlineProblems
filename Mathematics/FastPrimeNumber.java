/*
    Here is the problem: https://www.beecrowd.com.br/judge/en/problems/view/1221
    Here where I got the ideia to use sqr of the number, instead of looking for every single one:
    https://www.ti-enxame.com/pt/python/verificando-se-um-numero-e-um-numero-primo-em-python/970862199/
*/

package Mathematics;

import java.util.Scanner;

public class FastPrimeNumber {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberOfTestCases = reader.nextInt();
        long testNumber;
        for(int i = 0; i < numberOfTestCases; i++){
            testNumber = reader.nextLong();
            TestForPrime(testNumber);
        }
        reader.close();
    }
    public static void TestForPrime(long testNumber){
        String answer = "Prime";
        long squareRootTestNumber = (long) Math.sqrt(testNumber);
        if (testNumber % 2 == 0 && testNumber != 2){
            answer = "Not Prime";
        }else{
            for (long i = 3; i <= squareRootTestNumber; i+=2){
                if (testNumber % i == 0){
                    answer = "Not Prime";
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
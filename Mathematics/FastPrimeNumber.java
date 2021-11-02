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
        long squareRootTestNumber = (long) Math.sqrt(testNumber) + 1;
        if (testNumber % 2 == 0 && testNumber != 2){
            answer = "Not Prime";
        }else{
            for (long i = 3; i < squareRootTestNumber; i+=2){
                if (testNumber % i == 0){
                    answer = "Not Prime";
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
package Mathematics;

/*
Here is the problem: https://www.beecrowd.com.br/judge/en/problems/view/1563
*/
import java.util.Scanner;
public class TheBigProblem {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n;
        int numberOfCombination = 0, possibilities;
        try{
            while(reader.hasNextInt()){
                n = reader.nextInt();
                // operador ternário
                possibilities = (n == 2)? 1 : n*n;
                numberOfCombination = CalculatePossibilities(n);
                CalculateGreatestCommonDivisor(numberOfCombination, possibilities);
            }
        }catch(Exception ex){
            reader.close();
        }
    }
    public static int CalculatePossibilities(int n){
        int a, numberOfCombination = 0;
        /*
            I don't have to know every combination, just how many;
            The condition is that B <= the remainer of n / a;
            There is a number of possibilities igual to B
            */
        for(a = 2; a <= n; a++){
            numberOfCombination += n % a;
        }
        return numberOfCombination;
    }
    // Greatest Common Divisor by try an error
    public static void CalculateGreatestCommonDivisor(int numberOfCombination, int possibilities){
        for (int i = numberOfCombination; i >= 2; i--){
            if (numberOfCombination % i == 0){
                if (possibilities % i == 0){
                    numberOfCombination /= i;
                    possibilities /= i;
                    break;
                }
            }
        }
        System.out.println(numberOfCombination + "/" + possibilities);
    }
}
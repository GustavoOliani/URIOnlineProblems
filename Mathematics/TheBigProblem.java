package Mathematics;

/*
Here is the problem: https://www.beecrowd.com.br/judge/en/problems/view/1563
*/
import java.util.Scanner;
public class TheBigProblem {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int a, b, counter = 0, condition, possibilities;
        if (n == 2){
            possibilities = 1;
        }else{
            possibilities = n*n;
        }
        
        for(a = 2; a <= n; a++){
            condition = n % a;
            for(b = 1; b <= condition; b++){
                counter++;
            }
        }
        for (int i = counter; i >= 2; i--){
            if (counter % i == 0 && possibilities % i == 0){
                counter = counter / i;
                possibilities = possibilities / i;
                break;
            }
        }
        System.out.println(counter + "/" + possibilities);
        reader.close();
    }
}
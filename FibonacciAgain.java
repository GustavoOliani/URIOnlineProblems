import java.util.Scanner;

public class FibonacciAgain {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);

        while(reader.hasNextLine()){
            int n = reader.nextInt();
            int m = reader.nextInt();

            long fib1 = 1;
            long fib2 = 0;
            long inter = 0;
            for (int i = 1; i < n; i++){
                inter = fib1;
                fib1 += fib2;
                fib2 = inter;
            }
            n = (int) fib1;
            fib1 = 1;
            fib2 = 0;
            inter = 0;
            for (int i = 1; i < n; i++){
                inter = fib1;
                fib1 += fib2;
                fib2 = inter;
            }
            System.out.println(fib1/m);
        }
        reader.close();
    }
}

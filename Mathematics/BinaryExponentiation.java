package Mathematics;

import java.util.Scanner;

public class BinaryExponentiation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int base = 2;
        int n = reader.nextInt();
        System.out.println(binaryExp(base, n));
        reader.close();
    }

    public static int binaryExp(int base, int expoente){
        if(expoente == 0) return 1;
        else if(expoente == 1) return base;
        else{
            int r = binaryExp(base, (int) expoente/2);
            if(expoente % 2 == 0) {
                return r * r;
            }
            else return r * r * base;
        }
    }
}

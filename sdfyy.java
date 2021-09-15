package umn;

import java.util.Scanner;

public class сдфыы {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("1 число");
        int a = in.nextInt();
        System.out.println("2 число");
        int b = in.nextInt();
        System.out.println(product(a, b));
    }
    static int product(int a, int b) {
        if( a ==0 || b == 0)
        {
            return 0;
        }
        if (b==1)
        {
            return a;
        }
        else
        {
            return a + product(a, b - 1);
        }
    }
}

package com.multiply;

public class programm {
        public static void main() {
            System.out.print(multiply(150, 4));
        }
        public static int product(int a, int b) {
            if (a == 0 || b == 0) {
                return 0;
            }
            if (b == 1) {
                return a;
            }
            if (a == 1) {
                return b;
            }
            return a + product(a, b - 1);
        }
        public static int multiply(int a, int b)
        {
            int m = product(a, Math.abs(b));
            return (b < 0) ? -m : m;
        }
}

package Mathmatics;

import java.util.Scanner;

public class BJ6591 {
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        bC();
    }

    private static void bC() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int div = 1;
            long ans = 1;

            if (a == 0 && b == 0) {
                break;
            }

            // using nCr = nCn-r
            if (a - b < b) {
                b = a - b;
            }

            while (b-- > 0) {
                ans *= a--;
                ans /= div++;
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
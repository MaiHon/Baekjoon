package Mathmatics;

import java.util.Scanner;

public class BJ11050 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int ans = binomialCoefficient(N, K);
        System.out.println(ans);
    }

    private static int binomialCoefficient(int N, int K){
        int numerator = 1;
        int denominator = 1;

        for(int i=N; i>N-K; i--){
            numerator *= i;
        }

        for(int i=K; i>0; i--){
            denominator *= i;
        }

        return numerator/denominator;
    }
}

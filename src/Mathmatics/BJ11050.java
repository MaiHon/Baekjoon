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

    // 파스칼의 항등식 C(n, k) + C(n, k+1) = C(n+1, k+1)
    private static int binomialCoef(int N, int K){
        if(N==K||K==0) return 0;

        return binomialCoef(N-1, K-1) + binomialCoef(N-1, K);
    }
}

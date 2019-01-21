package Dynamic_Programming;

import java.math.*;
import java.util.*;

public class BJ10826 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger[] fibo = new BigInteger[Math.max(n+1, 2)];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;

        for(int i=2; i<=n; i++){
            fibo[i] = fibo[i-1].add(fibo[i-2]);
        }
        System.out.println(fibo[n]);
    }
}

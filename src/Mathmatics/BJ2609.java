package Mathmatics;

import java.util.*;

public class BJ2609 {

    static int GCD(int a, int b){
        if(b==0) return a;
        else return GCD(b, a%b);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = GCD(a,b);
        int lcm = gcd * (a/gcd) * (b/gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }
}

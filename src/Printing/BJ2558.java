package Printing;

import java.util.Scanner;

public class BJ2558{
    public static void main(String [] args){
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        
        System.out.format("%d", a+b);
    }
}
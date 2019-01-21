package Printing;

import java.util.*;
import java.io.*;

public class BJ2445 {
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                bw.write("*");
            }
            for(int j=1; j<=2*(n-i); j++){
                bw.write(" ");
            }
            for(int j=1; j<=i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i=n-1; i>0; i--){
            for(int j=1; j<=i; j++){
                bw.write("*");
            }
            for(int j=1; j<=2*(n-i); j++){
                bw.write(" ");
            }
            for(int j=1; j<=i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

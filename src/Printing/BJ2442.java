package Printing;

import java.util.*;
import java.io.*;

public class BJ2442 {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                bw.write(" ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
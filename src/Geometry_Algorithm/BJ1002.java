package Geometry_Algorithm;

import java.io.*;
import java.util.Scanner;

public class BJ1002 {
    public static void main(String args[]) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int caseN = scanner.nextInt();

        for(int i=0; i<caseN; i++){
            int x1, y1, r1, x2, y2, r2;
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            r1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            r2 = scanner.nextInt();

            double distance  = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
            int r = r1+r2;

            if(r1==r2 && x1==x2 && y1==y2){
                bw.write(-1 +"\n");
            }else if((x1==x2 && y1==y2 && r1!=r2)||distance>r||Math.abs(r1-r2)>distance){
                bw.write(0 +"\n");
            }else if(distance==r||distance==Math.abs(r1-r2)){
                bw.write(1 +"\n");

            }else{
                bw.write(2 +"\n");
            }
        }
        bw.flush();
    }
}

package Brute_Force;

import java.io.*;
import java.util.*;

public class BJ2309 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int smuf[] = new int[10];
        int map[][] = new int[10][10];
        int total = 0;

        for(int i=1; i<=9; i++){
            smuf[i] = Integer.parseInt(br.readLine());
            total += smuf[i];
        }

//        System.out.println();
//        System.out.println(Arrays.toString(smuf));

        Outter : for(int i=1; i<=9; i++){
            for(int j=2; j<=9; j++){
                map[i][j] = total - smuf[i] - smuf[j];
                if(map[i][j]==100){
                    smuf[i] = smuf[j] = 0;
                    break Outter;
                }
            }
        }

        Arrays.sort(smuf);
        for(int i : smuf){
            if(i!=0) sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}

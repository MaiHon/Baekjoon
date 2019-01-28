package Mathmatics;

import java.util.*;
import java.io.*;

public class BJ1850 {

    static long euclid(long a, long b){
        if(b==0){
            return a;
        }
        else{
            return euclid(b, a%b);
        }
    }

    public static void main(String args[])throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long t = euclid(a, b);
        if(t>10000000) t=10000000;

        while (t-- > 0)
        {
            sb.append("1");
        }
        System.out.println(sb);

    }
}

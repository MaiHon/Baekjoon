package Mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1934 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = euclid(a, b);
            int lcm = gcd * (a/gcd) * (b/gcd);
            sb.append(lcm + "\n");
        }

        System.out.println(sb);
    }

    static int euclid(int a, int b){
        if(b==0) return a;
        else return euclid(b, a%b);
    }
}

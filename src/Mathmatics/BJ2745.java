package Mathmatics;

import java.io.*;

public class BJ2745 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        char[] charray = str[0].toCharArray();

        int B = Integer.parseInt(str[1]);

        long ans = 0;
        int len = charray.length - 1;

        for(int i=0; i<=len; i++){
            char c = charray[i];
            int tmp;

            if('A' <= c && 'Z' >= c) {
                tmp = (int) (c - 'A') + 10;
            } else {
                tmp = (int) (c - '0');
            }

            ans += (long)Math.pow(B, len-i) * tmp;
        }
        System.out.println(ans);
    }
}

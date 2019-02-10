package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251_Recursive {
    public static void main(String args[])throws IOException {
        long stime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int f_len = first.length;
        int s_len = second.length;

        System.out.println(lcs(first, second, f_len, s_len));
        long etime = System.currentTimeMillis();
        System.out.println(etime-stime);
    }

    static int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }
}

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ9251_Better_Recursive {
    static int f_len, s_len;
    static int result;
    static int[][] answer;
    public static void main(String args[])throws IOException {
        long stime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        f_len = first.length;
        s_len = second.length;

        answer = new int[f_len+1][s_len+1];
        for(int[] row: answer){
            Arrays.fill(row, -1);
        }

        System.out.println(lcs(first, second, f_len, s_len));

        long etime = System.currentTimeMillis();
        System.out.println(etime-stime);
    }

    static int lcs( char[] X, char[] Y, int m, int n ) {

        if(answer[m][n]!=-1) return answer[m][n];

        if(m==0 || n==0) {
            return 0;
        }
        if(X[m-1]==Y[n-1]) {
            result = 1+ lcs(X, Y, m-1, n-1);
        }
        else {
            result = Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
        }
        answer[m][n] = result;
        return result;
    }
}

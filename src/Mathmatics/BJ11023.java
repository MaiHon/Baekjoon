package Mathmatics;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BJ11023 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int sum = 0;
        while(st.hasMoreTokens()){
            sum += Integer.valueOf(st.nextToken());
        }

        System.out.println(sum);
    }
}

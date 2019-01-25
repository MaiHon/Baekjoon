package Dynamic_Programming;

        import java.util.*;
        import java.io.*;

public class BJ11727 {
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2)%10007;
        }

        bw.write(dp[n] +"");
        bw.flush();
    }
}
